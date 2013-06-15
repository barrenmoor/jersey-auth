package org.barrenmoor.jersey.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.barrenmoor.jersey.auth.roles.RoleProvider;
import org.barrenmoor.jersey.auth.roles.RolesRequired;

import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;

public class AuthResourceFilterFactory implements ResourceFilterFactory {
	private static RoleProvider roleProvider = null;

	public List<ResourceFilter> create(AbstractMethod method) {
		List<ResourceFilter> list = new ArrayList<ResourceFilter>();

		if(method.isAnnotationPresent(RolesRequired.class)) {
			RolesRequired annotation = method.getAnnotation(RolesRequired.class);
			ResourceFilter resourceFilter = new AuthResourceFilter(
													Arrays.asList(annotation.roles()), 
													annotation.condition(), 
													roleProvider);
			list.add(resourceFilter);
		}

		return list;
	}
	
	public static void setRoleProvider(RoleProvider roleProvider) {
		AuthResourceFilterFactory.roleProvider = roleProvider;
	}
}
