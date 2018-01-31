package com.tbc.playarea.javalearning.tasks.refactorBook;

import java.util.Date;

public abstract class Book {
	
	public static final int FICTION = 1;
	public static final int NON_FICTION = 2;
	public static final int CHILDRENS = 3;
	
	private Date releaseDate;

	private long id;
	private String title;
	private int bookCategory;

	public Book(final String title, final int bookCategory, final Date releaseDate) {
		super();
		this.title = title;
		this.bookCategory = bookCategory;
		this.releaseDate = releaseDate;
	}

	public Book(final String title, final int bookCategory) {
		super();
		this.title = title;
		this.bookCategory = bookCategory;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(int bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	public abstract double getPriceonBook(int rentedDays);
	
	public abstract int getBookPoints(int rentedDays);

}
