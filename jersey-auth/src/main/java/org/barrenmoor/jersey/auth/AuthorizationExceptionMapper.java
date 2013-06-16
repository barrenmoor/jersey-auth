package org.barrenmoor.jersey.auth;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Provider
public class AuthorizationExceptionMapper implements
		ExceptionMapper<AuthorizationException> {

	@Context
	HttpHeaders headers;
	
	public Response toResponse(AuthorizationException e) {
		return Response
					.status(e.getStatus())
					.entity(new ExceptionDetails(
							e.getStatus().toString(),
							e.getStatus().getReasonPhrase(),
							e.getMessage()))
					.type(headers.getMediaType())
					.build();
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ExceptionDetails {
		@SuppressWarnings("unused")
		private String status;
		@SuppressWarnings("unused")
		private String reason;
		@SuppressWarnings("unused")
		private String message;
		
		public ExceptionDetails() {
			//do nothing
		}
		
		public ExceptionDetails(String status, String reason, String message){
			this.status = status;
			this.reason = reason;
			this.message = message;
		}
	}
	
}
