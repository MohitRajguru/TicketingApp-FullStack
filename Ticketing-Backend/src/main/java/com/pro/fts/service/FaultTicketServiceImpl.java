package com.pro.fts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.fts.entity.FaultTicket;
import com.pro.fts.entity.PageResponse;
import com.pro.fts.exception.ResourceNotFoundException;
import com.pro.fts.repository.TicketRepo;

@Service
public class FaultTicketServiceImpl implements FaultTicketService {

	@Autowired
	private TicketRepo ticketRepo;

// Save operation
	@Override
	public FaultTicket createFaultTicket(FaultTicket faultTicket) {
		return ticketRepo.save(faultTicket);
	}

// Read operation
	@Override
	public PageResponse<FaultTicket> getFaultTicketList(Pageable pageable) {

		Page<FaultTicket> faultTicketPage = ticketRepo.findAll(pageable);
		List<FaultTicket> faultTicketList = faultTicketPage.getContent();

		PageResponse<FaultTicket> pageResponse = new PageResponse<>();

		pageResponse.setContent(faultTicketList);
		pageResponse.setPageNumber(faultTicketPage.getNumber());
		pageResponse.setPageSize(faultTicketPage.getSize());
		pageResponse.setTotalElements(faultTicketPage.getTotalElements());
		pageResponse.setTotalPages(faultTicketPage.getTotalPages());
		pageResponse.setLastPage(faultTicketPage.isLast());
		return pageResponse;
	}

// Update operation
	@Override
	public FaultTicket updateFaultTicket(FaultTicket faultTicket, Integer ticketId) {

		FaultTicket faultTicketData = ticketRepo.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket ", "Ticket Id", ticketId));

		faultTicketData.setCreatedBy(faultTicket.getCreatedBy());
		faultTicketData.setDescription(faultTicket.getDescription());
		faultTicketData.setStatus(faultTicket.getStatus());
		faultTicketData.setType(faultTicket.getType());

		FaultTicket faultTicketCreated = ticketRepo.save(faultTicketData);

		return faultTicketCreated;
	}

// Delete operation
	@Override
	public String deleteFaultTicketById(Integer ticketId) {
		FaultTicket faultTicket = ticketRepo.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket ", "Ticket Id", ticketId));

		ticketRepo.delete(faultTicket);

		return "Deleted Successfully...!";
	}

// view fault ticket by type
// @Override
// public List<FaultTicket> viewByType(String type) {
// List<FaultTicket> f = ticketRepo.findByType(type);
// if (f.isEmpty()) {
// throw new TypeNotFoundException("(Invalid Type: " + type + ") - Must be 'fault' or 'incident'.");
// }
// return ticketRepo.findByType(type);
// }

// view fault ticket by status
// @Override
// public List<FaultTicket> viewByStatus(String status) {
// List<FaultTicket> f = ticketRepo.findByStatus(status);
// if (f.isEmpty()) {
// throw new StatusNotFoundException("(Invalid Status: " + status + ") - Must be 'completed' or 'pending'.");
// }
// return ticketRepo.findByStatus(status);
// }

// @Override
// public List<FaultTicket> getTicketsByDateRange(
// @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
// @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
// if (startDate == null || endDate == null || startDate.isAfter(endDate)) {
// throw new InvalidDateRangeException("Please check date format");
// }
// return ticketRepo.findByCreatedOnBetween(startDate, endDate);
// }

	@Override
	public List<FaultTicket> getTicketsByTypeStatusOrDateRange(@RequestParam("type") String type,
			@RequestParam("status") String status, @RequestParam("startDate") LocalDate startDate,
			@RequestParam("endDate") LocalDate endDate) {
		return ticketRepo.findByTypeAndStatusAndCreatedOnBetween(type, status, startDate, endDate);
	}

}
