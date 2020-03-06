package org.javacodemarina.webservices.rest.ticket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Ouner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OUNER_ID")
	private Long ounerId;
	
	private String oname;
	private int budget;
	private String text;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TICKET_ID")
	@JsonIgnore
	private Ticket ticket;
}