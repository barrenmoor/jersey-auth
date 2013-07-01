package org.barrenmoor.jersey.schematest.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonTypeName;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("dbConnectionParams")
public class DBConnectionParams extends ConnectionParams {
	@XmlElement
	private String host;
	@XmlElement
	private String databaseName;
	@XmlElement
	private String port;

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
}
