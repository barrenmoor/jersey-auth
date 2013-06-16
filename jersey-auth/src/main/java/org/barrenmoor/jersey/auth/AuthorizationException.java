package org.barrenmoor.jersey.auth;

import javax.ws.rs.core.Response.Status;

public class AuthorizationException extends RuntimeException {

	private static final long serialVersionUID = 3274313063272218991L;
	
	private Status status;
	
	public AuthorizationException(Status status, String message) {
		super(message);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
}
