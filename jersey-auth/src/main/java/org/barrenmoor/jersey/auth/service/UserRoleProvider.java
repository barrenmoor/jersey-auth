package org.barrenmoor.jersey.auth.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.barrenmoor.jersey.auth.roles.RoleProvider;

/**
 * 
 * @author rajagopal
 *
 */
public class UserRoleProvider implements RoleProvider {

	public List<String> roles() {
		List<String> roles = new ArrayList<String>();
		
		try {
			ResourceBundle bundle = PropertyResourceBundle.getBundle("org.barrenmoor.jersey.auth.service.rolefilepath");
			String filePath = (String)bundle.getObject("file.path");

			File f = new File(filePath, "roles.txt");
			System.out.println("path to roles.txt: " + f.getAbsolutePath());

			String rolesStr = getRolesString(f);
			StringTokenizer tokenizer = new StringTokenizer(rolesStr, "|");
			
			while(tokenizer.hasMoreTokens()) {
				roles.add(tokenizer.nextToken().trim());
			}
			
			roles.remove("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roles;
	}

	private String getRolesString(File f) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(f);
		StringBuffer buff = new StringBuffer();
		int c = -1;
		
		while((c = fis.read()) != -1) {
			buff.append((char)c);
		}
		
		fis.close();
		return buff.toString();
	}
}
