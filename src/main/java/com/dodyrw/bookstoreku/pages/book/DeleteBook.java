/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
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
    private Book book;

    @Inject
    private Session session;

    @InjectPage
    private ListBook listBook;
    
    // onActivate() is called by Tapestry to pass in the activation context from the URL.

    void onActivate(Book book) {
        this.book = book;
    }
    
    public void setupRender() {
		session.beginTransaction();
    		session.delete(book);
    		session.getTransaction().commit();
    }
}