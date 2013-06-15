package org.barrenmoor.jersey.auth;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.barrenmoor.jersey.auth.roles.RoleProvider;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class CustomJerseyServlet extends ServletContainer {

	private static final long serialVersionUID = -6503099059122041064L;
	private static final String ROLE_PROVIDER = "org.barrenmoor.jersey.auth.RoleProvider";
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String roleProviderClass = config.getInitParameter(ROLE_PROVIDER);

		try {
			@SuppressWarnings("unchecked")
			Class<? extends RoleProvider> clazz = (Class<? extends RoleProvider>) Class.forName(roleProviderClass);
			RoleProvider roleProvider = clazz.newInstance();
			AuthResourceFilterFactory.setRoleProvider(roleProvider);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Role Provider " + roleProviderClass + " could not be instantiated.", e);
		}

		super.init(config);
	}
}
