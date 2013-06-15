package org.barrenmoor.jersey.auth.service;

import java.util.Arrays;
import java.util.List;

import org.barrenmoor.jersey.auth.roles.RoleProvider;

/**
 * 
 * @author rajagopal
 *
 */
public class UserRoleProvider implements RoleProvider {

	public List<String> roles() {
		return Arrays.asList("STORE_KEEPER");
	}
}
