package br.com.winvesti.helpdesk.domain;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.winvesti.helpdesk.domain.enums.Priority;
import br.com.winvesti.helpdesk.domain.enums.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Request {

	@EqualsAndHashCode.Include
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant created_at = Instant.now();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant closed_at = Instant.now();

	private String title;
	private String comments;

	private Priority priority;
	private Status status;

	private Client client;
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
