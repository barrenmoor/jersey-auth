package org.barrenmoor.jersey.schematest.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonTypeName;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeName("jmsConnectionParams")
public class JMSConnectionParams extends ConnectionParams {
	@XmlElement
	private String brokerUrl;

	public String getBrokerUrl() {
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}
}
