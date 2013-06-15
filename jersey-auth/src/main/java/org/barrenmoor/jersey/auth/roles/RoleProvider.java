package org.barrenmoor.jersey.auth.roles;

import java.util.List;

public interface RoleProvider {
	public List<String> roles();
}
