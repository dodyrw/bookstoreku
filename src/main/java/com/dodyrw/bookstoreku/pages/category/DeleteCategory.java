/**
 * 
 */
package com.dodyrw.bookstoreku.pages.category;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Category;
import com.dodyrw.bookstoreku.pages.book.ListBook;

/**
 * @author dodyrw
 *
 */
public class DeleteCategory {
    private Category category;

    @Inject
    private Session session;

    @InjectPage
    private ListBook listBook;
    
    // onActivate() is called by Tapestry to pass in the activation context from the URL.

    void onActivate(Category category) {
        this.category = category;
    }
    
    public void setupRender() {
		session.beginTransaction();
    		session.delete(category);
    		session.getTransaction().commit();
    }
}