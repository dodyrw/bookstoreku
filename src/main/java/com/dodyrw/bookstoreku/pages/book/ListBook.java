/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import java.util.Iterator;
import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
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
	
	@Property
    private Book currentBook;
	 
	// simple grid
	
	public List<Book> getBooks()
	{
//		List<Book> books = session.createCriteria(Book.class).list();		
//		for (Iterator<Book> i = books.iterator(); i.hasNext();) {
//		    Book book = (Book) i.next();
//		    System.out.println("Book: "+book.category.name);
//		}
		
	    return session.createCriteria(Book.class).list();
	}
	
	// alternative
	
	public GridDataSource getBooks2() {
        return new HibernateGridDataSource(session,Book.class);
    }
}