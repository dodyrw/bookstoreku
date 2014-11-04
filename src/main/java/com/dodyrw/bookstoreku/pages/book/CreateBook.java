/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Book;

/**
 * @author dodyrw
 *
 */
public class CreateBook {
	@Property
	private Book book;
	
    @Inject
    private Session session;
 
    @InjectPage
    private ListBook listBook;
 
    @CommitAfter
    Object onSuccess()
    {
        session.persist(book);
 
        return listBook;
    }
}