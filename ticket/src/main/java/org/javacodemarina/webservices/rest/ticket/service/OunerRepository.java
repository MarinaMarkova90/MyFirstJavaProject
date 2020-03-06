package org.javacodemarina.webservices.rest.ticket.service;

import org.javacodemarina.webservices.rest.ticket.domain.Ouner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OunerRepository extends JpaRepository<Ouner, Long> {

}