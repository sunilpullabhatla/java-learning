package com.tbc.playarea.javalearning.tasks.refactorBook;

import java.util.Date;

public class NonFictionBook extends Book {
	
	public NonFictionBook (final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}		

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
