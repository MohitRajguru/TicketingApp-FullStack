package com.pro.fts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.fts.entity.FaultTicket;
import com.pro.fts.entity.PageResponse;
import com.pro.fts.service.FaultTicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FaultTicketTests {

	@Autowired
	private MockMvc restMockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@MockBean
	private FaultTicketService faultTicketService;

// JUnit test for CREATE FaultTicket by REST API
	@Test
	public void shouldCreateFaultTicketTesting() throws Exception {

// given - precondition or setup
		FaultTicket faultTicketPostData = new FaultTicket();
		faultTicketPostData.setType("fault");
		faultTicketPostData.setStatus("completed");
		faultTicketPostData.setDescription("this is demo description");
		faultTicketPostData.setCreatedBy("MockUser01");

		given(faultTicketService.createFaultTicket(any(FaultTicket.class))).willReturn((faultTicketPostData));

// when - action and behavior that we are going to test
		ResultActions response = restMockMvc
				.perform(post("/fault-ticket/tickets").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsBytes(faultTicketPostData)))
				.andExpect(status().isCreated()).andDo(print());

// then - verify the result and output using assert statements
		response.andExpect(status().isCreated())
				.andExpect(jsonPath("$.description", is(faultTicketPostData.getDescription())));

	}

// JUnit test for GET all FaultTicket
	@Test
	public void shouldGetAllFaultTicketTesting() throws Exception {

// given - precondition or setup
		List<FaultTicket> faultTicketList = new ArrayList<>();

		FaultTicket faultTicketPostData1 = new FaultTicket();
		faultTicketPostData1.setType("fault");
		faultTicketPostData1.setStatus("completed");
		faultTicketPostData1.setDescription("this is demo description");
		faultTicketPostData1.setCreatedBy("Dhoni");

		FaultTicket faultTicketPostData2 = new FaultTicket();
		faultTicketPostData2.setType("fault");
		faultTicketPostData2.setStatus("completed");
		faultTicketPostData2.setDescription("this is test description");
		faultTicketPostData2.setCreatedBy("Kohli");

		faultTicketList.add(faultTicketPostData1);
		faultTicketList.add(faultTicketPostData2);

		PageResponse<FaultTicket> pageResponse = new PageResponse<>();
		pageResponse.setContent(faultTicketList);
		pageResponse.setTotalElements(faultTicketList.size());

		given(faultTicketService.getFaultTicketList(any(Pageable.class))).willReturn((pageResponse));

// when - action and behavior that we are going to test
		ResultActions response = restMockMvc
				.perform(get("/fault-ticket/tickets").contentType(MediaType.APPLICATION_JSON));

// then - verify the result and output using assert statements
		response.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.totalElements", is(faultTicketList.size())));

	}

// JUnit test for UPDATE FaultTicket by REST API
	@Test
	public void shouldUpdateFaultTicketById() throws Exception {

// given - precondition or setup
		Integer faultTicketId = 101;

		FaultTicket faultTicketPostData = new FaultTicket();
		faultTicketPostData.setTicketId(faultTicketId);
		faultTicketPostData.setType("fault");
		faultTicketPostData.setStatus("completed");
		faultTicketPostData.setDescription("this is demo description");
		faultTicketPostData.setCreatedBy("Dhoni");

		given(faultTicketService.updateFaultTicket(any(FaultTicket.class), any(Integer.class)))
				.willReturn(faultTicketPostData);

// when - action and behavior that we are going to test
		ResultActions response = restMockMvc.perform(put("/fault-ticket/tickets" + "/{id}", faultTicketId)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(faultTicketPostData)));

// then - verify the result and output using assert statements
		response.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.description", is(faultTicketPostData.getDescription())));

	}

// JUnit test for DELETE FaultTicket by REST API
	@Test
	public void shouldDeleteFaultTicket() throws Exception {

// given - precondition or setup
		Integer faultTicketId = 101;

		given(faultTicketService.deleteFaultTicketById(any(Integer.class))).willReturn("Deleted Successfully...!");

// when - action and behavior that we are going to test

		ResultActions response = restMockMvc.perform(delete("/fault-ticket/tickets" + "/{id}", faultTicketId));

// then - verify the result and output using assert statements
		response.andExpect(status().isOk()).andDo(print());

	}

// JUnit test for GET all FaultTicket
	@Test
	public void shouldGetAllFaultTicketTestingByType() throws Exception {

// given - precondition or setup
		List<FaultTicket> faultTicketList = new ArrayList<>();

		FaultTicket faultTicketPostData1 = new FaultTicket();
		faultTicketPostData1.setType("fault");
		faultTicketPostData1.setStatus("completed");
		faultTicketPostData1.setDescription("this is demo description");
		faultTicketPostData1.setCreatedBy("Dhoni");

		FaultTicket faultTicketPostData2 = new FaultTicket();
		faultTicketPostData2.setType("incident");
		faultTicketPostData2.setStatus("completed");
		faultTicketPostData2.setDescription("this is test description");
		faultTicketPostData2.setCreatedBy("Kohli");

		faultTicketList.add(faultTicketPostData1);
		faultTicketList.add(faultTicketPostData2);

		PageResponse<FaultTicket> pageResponse = new PageResponse<>();
		pageResponse.setContent(faultTicketList);
		pageResponse.setTotalElements(faultTicketList.size());

		given(faultTicketService.getFaultTicketList(any(Pageable.class))).willReturn((pageResponse));

// when - action and behavior that we are going to test
		ResultActions response = restMockMvc
				.perform(get("/fault-ticket/tickets").contentType(MediaType.APPLICATION_JSON));

// then - verify the result and output using assert statements
		response.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.totalElements", is(faultTicketList.size())));

	}
}
