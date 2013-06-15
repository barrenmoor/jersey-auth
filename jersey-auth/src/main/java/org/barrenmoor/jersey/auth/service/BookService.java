package org.barrenmoor.jersey.auth.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.barrenmoor.jersey.auth.roles.Roles;
import org.barrenmoor.jersey.auth.roles.RolesRequired;

@Path("/books")
public class BookService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesRequired(roles = {"STORE_KEEPER"}, condition = Roles.ANY)
	public Book getBook() {
		return new Book("isbn1", "A Farewell to Arms", "Ernest Hemingway");
	}
}
