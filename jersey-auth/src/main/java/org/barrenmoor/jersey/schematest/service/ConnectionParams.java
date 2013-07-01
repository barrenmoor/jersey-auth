package org.barrenmoor.jersey.schematest.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

@XmlRootElement
@XmlSeeAlso({DBConnectionParams.class, JMSConnectionParams.class})
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME,
	include = JsonTypeInfo.As.PROPERTY,
	property = "type"
)
@JsonSubTypes({
	@Type(value=JMSConnectionParams.class, name="jmsConnectionParams"),
	@Type(value=DBConnectionParams.class, name="dbConnectionParams")
})
public abstract class ConnectionParams {
	@XmlElement
	private String userId;
	@XmlElement
	private String password;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
