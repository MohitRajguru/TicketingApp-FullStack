package com.pro.fts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro.fts.entity.FaultTicket;

@Repository
public interface TicketRepo extends JpaRepository<FaultTicket, Integer> {

// List<FaultTicket> findByType(String type);
//
// List<FaultTicket> findByStatus(String status);
//
// List<FaultTicket> findByCreatedOnBetween(LocalDate startDate, LocalDate endDate);

	@Query("SELECT t FROM FaultTicket t WHERE " + "(:type is null OR t.type = :type) AND "
			+ "(:status is null OR t.status = :status) AND " + "((:startDate IS NULL AND :endDate IS NULL)OR"
			+ "(t.createdOn BETWEEN :startDate AND :endDate))")
	List<FaultTicket> findByTypeAndStatusAndCreatedOnBetween(@Param("type") String type, @Param("status") String status,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}