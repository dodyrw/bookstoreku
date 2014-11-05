/**
 * 
 */
package com.dodyrw.bookstoreku.pages.category;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Category;

/**
 * @author dodyrw
 *
 */
public class CreateCategory {
	@Property
	private Category category;
	
    @Inject
    private Session session;
 
    @InjectPage
    private ListCategory listCategory;
 
    @CommitAfter
    Object onSuccess()
    {
        session.persist(category);
 
        return listCategory;
    }
}