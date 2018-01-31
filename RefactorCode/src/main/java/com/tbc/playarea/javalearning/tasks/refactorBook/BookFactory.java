package com.tbc.playarea.javalearning.tasks.refactorBook;

import com.tbc.playarea.javalearning.tasks.refactorBook.Book;

public class BookFactory {
	
	public static  Book getBookInstance(int bookCategory){
		Book book = null;
		switch (bookCategory) {
		case Book.FICTION:
			book = new FictionBook("", 1);
			break;
		case Book.NON_FICTION:
			book = new NonFictionBook("", 2);
			break;
		case Book.CHILDRENS:
			book = new ChildrenBook("", 3);
			break;
		}
		return book;
		
	}

}
