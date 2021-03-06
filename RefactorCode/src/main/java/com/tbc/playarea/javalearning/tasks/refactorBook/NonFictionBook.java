package com.tbc.playarea.javalearning.tasks.refactorBook;

/**
 * Book type of NonFiction
 * 
 * @author Sunil Pavan
 *
 */
public class NonFictionBook extends Book {
	
	
	public NonFictionBook(String title, int bookCategory) {
		super(title, bookCategory);
	}

	@Override
	public double getPriceonBook(int rentedDays) {
		return rentedDays * 3;
	}

	@Override
	public int getBookPoints(int rentedDays) {
		return 1;
	}

}
