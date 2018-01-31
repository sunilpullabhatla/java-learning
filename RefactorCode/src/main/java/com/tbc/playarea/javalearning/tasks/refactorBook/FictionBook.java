package com.tbc.playarea.javalearning.tasks.refactorBook;

import java.util.Date;

import com.tbc.playarea.javalearning.tasks.refactorBook.Book;

public class FictionBook extends Book{
	

	private static final long serialVersionUID = 1L;
	
	public FictionBook (final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}		
	

	public FictionBook(String title, int bookCategory) {
		super(title, bookCategory);
		
	}
	


	public double getPriceonBook(int rentedDays) {
		double thisAmount = 2;
		if (rentedDays > 2)
			thisAmount += (rentedDays - 2) * 1.5;
		
		return thisAmount;
	}


	public int getBookPoints(int rentedDays) {
		int frequentRenterPoints = 1;
		if (rentedDays > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
