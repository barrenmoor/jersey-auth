package org.barrenmoor.jersey.schematest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/datasources")
public class DataSourceRESTProvider {
	
	@GET
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response get(@QueryParam("flag") String flag) {
		
		ConnectionParams cp = null;
		
		if("db".equals(flag)) {
			DBConnectionParams dbcp = new DBConnectionParams();
			dbcp.setDatabaseName("cuic_data");
			dbcp.setHost("10.78.90.103");
			dbcp.setPassword("89547384573");
			dbcp.setPort("1500");
			dbcp.setUserId("cuic_dbuser");
			cp = dbcp;
		} else {
			JMSConnectionParams jmscp = new JMSConnectionParams();
			jmscp.setUserId("jmsuser");
			jmscp.setPassword("jmspassword");
			jmscp.setBrokerUrl("http://jmsserver:9087/topics");
			cp = jmscp;
		}
		
		DataSource ds = new DataSource();
		
		ds.setId("id123");
		ds.setName("some name");
		ds.setConnectionParams(cp);
		
		return Response.status(Status.OK).entity(ds).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response post(DataSource ds) {
		System.out.println(ds.getConnectionParams().getClass().getName());
		return Response.status(Status.CREATED).build();
	}
}
