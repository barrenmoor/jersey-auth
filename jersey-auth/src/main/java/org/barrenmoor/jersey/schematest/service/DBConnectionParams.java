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
	@XmlElement(nillable=false, defaultValue="-3000000")
	private Integer port;

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
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
}
