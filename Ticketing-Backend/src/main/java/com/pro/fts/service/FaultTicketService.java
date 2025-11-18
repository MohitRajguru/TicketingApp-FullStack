package com.pro.fts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pro.fts.entity.FaultTicket;
import com.pro.fts.entity.PageResponse;

public interface FaultTicketService {

// Create operation
	FaultTicket createFaultTicket(FaultTicket faultTicket);

// Read operation
	PageResponse<FaultTicket> getFaultTicketList(Pageable pageable);

// Update operation
	FaultTicket updateFaultTicket(FaultTicket faultTicket, Integer ticketId);

// Delete operation
	String deleteFaultTicketById(Integer ticketId);

// view fault ticket by type
// public List<FaultTicket> viewByType(String type);

// view fault ticket by status
// public List<FaultTicket> viewByStatus(String status);

// view fault ticket by created between
// public List<FaultTicket> getTicketsByDateRange(LocalDate startDate, LocalDate endDate);

// view fault ticket by type, status and created between
	public List<FaultTicket> getTicketsByTypeStatusOrDateRange(String type, String status, LocalDate startDate,
			LocalDate endDate);

}