package org.javacodemarina.webservices.rest.ticket.service;

import org.javacodemarina.webservices.rest.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}