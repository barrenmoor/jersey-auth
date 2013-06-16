package org.barrenmoor.jersey.auth.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.barrenmoor.jersey.auth.roles.Roles;
import org.barrenmoor.jersey.auth.roles.Authorize;

@Path("/books")
public class BookService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Authorize(roles = {"STORE_KEEPER", "ACCOUNTANT"}, require = Roles.ANY)
	public Book getBook() {
		return new Book("isbn1", "A Farewell to Arms", "Ernest Hemingway");
	}
	
	@GET
	@Path("/secret")
	@Authorize(roles = {"ADMINISTRATOR", "ADVISOR"}, require = Roles.ALL)
	public Book getSecretBook() {
		return new Book("isbn2", "Crime and Punishment", "Fyodor Dostoevsky");
	}
}
