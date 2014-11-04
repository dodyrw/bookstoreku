package com.dodyrw.bookstoreku.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	public Long id;
	 
	@Validate("required,minLength=3")
	public String title;
	 
	@Validate("required")
	public String author;
	 
	@Validate("required")
	public String publisher;
}
