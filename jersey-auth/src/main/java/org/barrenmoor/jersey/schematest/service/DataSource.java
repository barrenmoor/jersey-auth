package org.barrenmoor.jersey.schematest.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSource {
	@XmlElement
	private String id;
	@XmlElement(nillable=false)
	private String name;
	@XmlElement
	private ConnectionParams connectionParams;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ConnectionParams getConnectionParams() {
		return connectionParams;
	}
	public void setConnectionParams(ConnectionParams connectionParams) {
		this.connectionParams = connectionParams;
	}

	
}
