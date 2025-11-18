package com.pro.fts.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.fts.entity.FaultTicket;
import com.pro.fts.entity.PageResponse;
import com.pro.fts.service.FaultTicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/fault-ticket")
@CrossOrigin("*")
public class FaultTicketController {

	@Autowired
	private FaultTicketService faultTicketService;

// Save operation
	@PostMapping("/tickets")
	public ResponseEntity<FaultTicket> createFaultTicket(@Valid @RequestBody FaultTicket faultTicket) {
		return new ResponseEntity<FaultTicket>(faultTicketService.createFaultTicket(faultTicket), HttpStatus.CREATED);
	}

// Read operation
	@GetMapping("/tickets")
	public ResponseEntity<PageResponse<FaultTicket>> getFaultTicketList(Pageable pageable) {
		return new ResponseEntity<>(faultTicketService.getFaultTicketList(pageable), HttpStatus.OK);
	}

// Update operation
	@PutMapping("/tickets/{ticketId}")
	public ResponseEntity<FaultTicket> updateFaultTicket(@Valid @RequestBody FaultTicket faultTicket,
			@PathVariable("ticketId") Integer ticketId) {
		return new ResponseEntity<FaultTicket>(faultTicketService.updateFaultTicket(faultTicket, ticketId),
				HttpStatus.OK);
	}

// Delete operations
	@DeleteMapping("/tickets/{ticketId}")
	public ResponseEntity<String> deleteFaultTicketById(@PathVariable("ticketId") Integer ticketId) {
		faultTicketService.deleteFaultTicketById(ticketId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/tickets/")
	public ResponseEntity<List<FaultTicket>> getTicketsByTypeStatusAndDateRange(
			@RequestParam(required = false) String type, @RequestParam(required = false) String status,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
		List<FaultTicket> tickets = faultTicketService.getTicketsByTypeStatusOrDateRange(type, status, startDate,
				endDate);
		Collections.sort(tickets, Comparator.comparing(FaultTicket::getTicketId).reversed());
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

}
