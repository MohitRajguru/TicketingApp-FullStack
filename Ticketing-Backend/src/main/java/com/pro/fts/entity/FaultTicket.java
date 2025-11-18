package com.pro.fts.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class FaultTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy("ticketId DESC")
	private int ticketId;

	@NotEmpty(message = "Type should not be empty")
	@Pattern(regexp = "^(fault|incident)$", message = "Type must be either 'fault' or 'incident'.")
	private String type;

	@NotEmpty(message = "Status should not be empty")
	@Pattern(regexp = "^(completed|pending)$", message = "Status must be either 'completed' or 'pending'.")
	private String status;

	@NotEmpty(message = "Description should not be empty")
	@Size(min = 10, max = 100, message = "Description must be between 10 and 100 characters.")
	private String description;

	@NotEmpty(message = "Name should not be empty")
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Name must contain only alphanumeric characters.")
	private String createdBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@CreationTimestamp
	private LocalDate createdOn;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public FaultTicket(int ticketId,
			@NotEmpty(message = "Type should not be blank") @Pattern(regexp = "^(fault|incident)$", message = "Type must be either 'fault' or 'incident'.") String type,
			@NotEmpty(message = "Status should not be blank") @Pattern(regexp = "^(completed|pending)$", message = "Status must be either 'completed' or 'pending'.") String status,
			@NotEmpty(message = "Description should not be blank") @Size(min = 10, max = 100, message = "Description must be between 10 and 100 characters.") String description,
			@NotEmpty(message = "Name should not be blank") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Name must contain only alphanumeric characters.") String createdBy,
			LocalDate createdOn) {
		super();
		this.ticketId = ticketId;
		this.type = type;
		this.status = status;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}

	public FaultTicket() {
// TODO Auto-generated constructor stub
	}

}
