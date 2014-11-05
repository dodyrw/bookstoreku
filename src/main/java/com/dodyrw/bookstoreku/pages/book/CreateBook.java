/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;

import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dodyrw.bookstoreku.entities.Book;
import com.dodyrw.bookstoreku.entities.Category;

/**
 * @author dodyrw
 *
 */
public class CreateBook {
	
	// Screen fields

    @Property
    private String title;

    @Property
    private String author;

    @Property
    private String publisher;

    @Property
    private Category category;

    @Inject
    private Session session;

    // Other pages

    @InjectPage
    private ListBook listBook;

    // Generally useful bits and pieces

    @Component(id = "books")
    private Form form;

    @Component(id = "title")
    private TextField titleField;

    @Component(id = "author")
    private TextField authorField;

    @Component(id = "publisher")
    private TextField publisherField;

    // The code

    void onValidateFromBooks() {
        if (title == null || title.trim().equals("")) {
            form.recordError(titleField, "Title is required.");
        }
        if (author == null || author.trim().equals("")) {
            form.recordError(authorField, "Author is required.");
        }
    }

    Object onSuccess() {
        // save
    	
    		System.out.println("T:"+title);
    	
    		Book book = new Book();
    		book.setTitle(title);
    		book.setAuthor(author);
    		book.setPublisher(publisher);
    		book.setCategory(category);
    	
    		session.beginTransaction();
    		session.save(book);
    		session.getTransaction().commit();
    		
    		return listBook;
    }
    
    public List<Category> getCategories() {
    		return session.createCriteria(Category.class).list();
    }
}