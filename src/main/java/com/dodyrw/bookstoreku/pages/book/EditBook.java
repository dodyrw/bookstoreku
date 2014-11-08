/**
 * 
 */
package com.dodyrw.bookstoreku.pages.book;


import java.util.List;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Hidden;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dodyrw.bookstoreku.entities.Book;
import com.dodyrw.bookstoreku.entities.Category;

/**
 * @author dodyrw
 *
 */
public class EditBook {
	
	// Screen fields

    @Property
    private String bookId;

    @Property
    private String title;

    @Property
    private String author;

    @Property
    private String publisher;

    @Property
    private Category category;

    @Property
    private Book book;

    @Inject
    private Session session;

    // Other pages

    @InjectPage
    private ListBook listBook;

    // Generally useful bits and pieces

    @Component(id = "book")
    private Form form;

    @Component(id = "bookId")
    private Hidden bookIdField;

    @Component(id = "title")
    private TextField titleField;

    @Component(id = "author")
    private TextField authorField;

    @Component(id = "publisher")
    private TextField publisherField;
    
    @Property
    private SelectModel categorySelectModel;
    
    @Inject
    SelectModelFactory selectModelFactory;

    // The code
   

    // onActivate() is called by Tapestry to pass in the activation context from the URL.

    void onActivate(Book book, String bookId, String title, String author, String publisher, Category category) {
        this.book = book;
        this.title = title;
        this.bookId = bookId;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }
    
    public Book getTheBook() {
    		System.out.println("bookID1:"+bookId);
    		Long id = Long.parseLong(bookId, 10);
		
		List<Book> books = session.createCriteria(Book.class)
					.add( Restrictions.idEq(id) )
					.list();
		Book book = books.get(0);
		return book;
    }

    
    // onPassivate() is called by Tapestry to get the activation context to put in the URL.

    Object[] onPassivate() {
        return new String[] { bookId, title, author, publisher };
    }
    
//    Book onPassivate() {
//        return new Book();
//    }

    Object onSuccess() {
    	System.out.println("submit!");
        // save
    	
    		Long id = Long.parseLong(bookId, 10);
    		
    		List<Book> books = session.createCriteria(Book.class)
    					.add( Restrictions.idEq(id) )
    					.list();
    		Book book = books.get(0);
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
    
    public void setupRender() {
		//System.out.println("T:"+book.title);
		
		// invoke my service to find all colors, e.g. in the database
	    List<Category> categories = session.createCriteria(Category.class).list();
	 
	    // create a SelectModel from my list of colors
	    categorySelectModel = selectModelFactory.create(categories, "name");
    }

}