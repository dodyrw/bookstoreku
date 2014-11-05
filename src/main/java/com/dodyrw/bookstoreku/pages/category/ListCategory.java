/**
 * 
 */
package com.dodyrw.bookstoreku.pages.category;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.hibernate.HibernateGridDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Category;

/**
 * @author dodyrw
 *
 */

public class ListCategory {
	@Inject
	private Session session;
	
	@Property
    private Category currentCategory;
	
	public GridDataSource getCategories() {
        return new HibernateGridDataSource(session,Category.class);
    }

}