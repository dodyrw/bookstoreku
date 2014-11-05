/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Book;

/**
 * @author dodyrw
 *
 */
public class EditBook {
	@PageActivationContext
    @Property
    @Persist("entity")
    private Book book;

    @Inject
    private Session session;

    @CommitAfter
    Object onSuccess() {
            session.update(book);
            return ListBook.class;
    }
}