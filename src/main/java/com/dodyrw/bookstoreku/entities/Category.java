package com.dodyrw.bookstoreku.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;
import org.hibernate.annotations.CascadeType;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.Set;

@Entity
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	public Long id;
	 
	@Validate("required")
	public String name;	 
	
	@OneToMany(mappedBy="category")
	public List<Book> books;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "developer_id")
//	private List<Book> moreHobbies = new ArrayList<Hobby>();	
	
//	@OneToMany
//    private Collection bookCollection;
}
