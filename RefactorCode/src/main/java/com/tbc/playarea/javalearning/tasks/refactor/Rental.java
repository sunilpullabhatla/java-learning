/**
 * 
 */
package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;

import com.tbc.playarea.javalearning.tasks.refactorBook.Book;
import com.tbc.playarea.javalearning.tasks.refactorBook.BookFactory;

/**
 * Represent a customer renting a book.
 * 
 * @author SunilP
 *
 */
public class Rental implements Serializable {

	private static final long serialVersionUID = 1256869448913370768L;

	private Book book;

	private int daysRented;

	public Rental(Book book, int daysRented) {
		super();
		this.book = book;
		this.daysRented = daysRented;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	
	public double fetchRent() {
		double thisAmount = 0;
		
		Book b = BookFactory.getBookInstance(book.getBookCategory());
		thisAmount =  b.getPriceonBook(getDaysRented());
		
		return thisAmount;
	}

	
	
	public int addPointer() {
		// add frequent renter points
		int frequentRenterPoints = 1;
		
		// add bonus for a two day new release rental
		if ((getBook().getBookCategory() == Book.FICTION) && getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
