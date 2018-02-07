package com.tbc.playarea.javalearning.tasks.refactorBook;


public class FictionBook extends Book{
	

	private static final long serialVersionUID = 1L;
	
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
