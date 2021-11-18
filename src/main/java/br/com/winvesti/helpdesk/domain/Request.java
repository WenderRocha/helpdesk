package br.com.winvesti.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.winvesti.helpdesk.domain.enums.Priority;
import br.com.winvesti.helpdesk.domain.enums.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Request implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created_at = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closed_at = LocalDate.now();

	private String title;
	private String comments;

	private Priority priority;
	private Status status;

	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "technical_id")
	private Technical technical;

	public Request() {
		super();
	}

	public Request(Long id, String title, String comments, Priority priority, Status status, Client client,
			Technical technical) {
		super();
		this.id = id;
		this.title = title;
		this.comments = comments;
		this.priority = priority;
		this.status = status;
		this.client = client;
		this.technical = technical;
	}

}
