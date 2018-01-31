package com.tbc.playarea.javalearning.tasks.refactorBook;

import java.util.Date;

public class ChildrenBook extends Book{
	
	public ChildrenBook (final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}		

	public ChildrenBook(String title, int bookCategory) {
		super(title, bookCategory);
	}

	@Override
	public double getPriceonBook(int rentedDays) {
		double thisAmount = 1.5;
		if (rentedDays > 3)
			thisAmount += (rentedDays - 3) * 2;
		return thisAmount;
	}

	@Override
	public int getBookPoints(int rentedDays) {
		return 1;
	}

}
