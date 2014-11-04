/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Book;

/**
 * @author dodyrw
 *
 */
public class ListBook {
	@Inject
	private Session session;
	 
	public List<Book> getBooks()
	{
	    return session.createCriteria(Book.class).list();
	}
}