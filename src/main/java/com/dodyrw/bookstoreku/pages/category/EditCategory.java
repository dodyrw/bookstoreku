/**
 * 
 */
package com.dodyrw.bookstoreku.pages.category;

import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Category;

/**
 * @author dodyrw
 *
 */
public class EditCategory {
	@PageActivationContext
    @Property
    @Persist("entity")
    private Category category;

    @Inject
    private Session session;

    @CommitAfter
    Object onSuccess() {
            session.update(category);
            return ListCategory.class;
    }

}