package org.barrenmoor.jersey.auth;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.barrenmoor.jersey.auth.roles.RoleProvider;
import org.barrenmoor.jersey.auth.roles.Roles;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

/**
 * 
 * @author rajagopal
 *
 */
public class AuthResourceFilter implements ResourceFilter, ContainerRequestFilter, ContainerResponseFilter {
	
	private List<String> requiredRoles;
	private RoleProvider roleProvider;
	private Roles condition;
	
	public AuthResourceFilter(List<String> requiredRole, Roles condition, RoleProvider roleProvider) {
		this.requiredRoles = requiredRole;
		this.condition = condition;
		this.roleProvider = roleProvider;
	}

	/**
	 * 
	 */
	public ContainerRequestFilter getRequestFilter() {
		return this;
	}

	/**
	 * 
	 */
	public ContainerResponseFilter getResponseFilter() {
		return this;
	}

	/**
	 * 
	 */
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		return response;
	}

	/**
	 * 
	 */
	public ContainerRequest filter(ContainerRequest request) {
		boolean hasRole = false;
		if(Roles.ANY.equals(condition)) {
			for(String role : roleProvider.roles()) {
				if(requiredRoles.contains(role)) {
					hasRole = true;
					break;
				}
			}
		} else if(Roles.ALL.equals(condition)) {
			for(String role : requiredRoles) {
				hasRole = true;
				if(!roleProvider.roles().contains(role)) {
					hasRole = false;
					break;
				}
			}
		}

		if(!hasRole) {
			throw new WebApplicationException(
						Response.status(Status.UNAUTHORIZED)
						.type(MediaType.APPLICATION_JSON_TYPE)
						.build());
		}

		return request;
	}
}
