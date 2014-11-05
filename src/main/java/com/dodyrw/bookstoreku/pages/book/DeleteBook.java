/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Book;

/**
 * @author dodyrw
 *
 */
public class DeleteBook {
    @Property
    @Persist("entity")
    private Book book;

    @Inject
    private Session session;
    
    public DeleteBook()
    {
    		session.delete(book);
    }
}