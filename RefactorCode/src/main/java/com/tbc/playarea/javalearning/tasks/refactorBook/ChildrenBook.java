package com.tbc.playarea.javalearning.tasks.refactorBook;


public class ChildrenBook extends Book{
	
		

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
