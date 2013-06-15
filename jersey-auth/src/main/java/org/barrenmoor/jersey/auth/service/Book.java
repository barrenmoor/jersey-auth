package org.barrenmoor.jersey.auth.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@SuppressWarnings("unused")
	private String isbn;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String author;
	
	public Book() {
		//do nothing
	}
	/**
	 * 
	 * @param isbn
	 * @param name
	 * @param author
	 */
	public Book(String isbn, String name, String author) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
	}
}
