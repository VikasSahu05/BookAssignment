package com.techment.bookutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import com.techment.bookutil.InvalidCategoryException;
import com.techment.bookutil.InvalidIDException;
import com.techment.bookutil.InvalidNegativePriceException;
import com.techment.bookutil.*;

public class BookStore {

	public static void main(String[] args) throws  com.techment.bookutil.InvalidIDException, InvalidNegativePriceException, InvalidCategoryException {
		Collection<Book> bookCollection = new ArrayList<Book>();
		
		Scanner s = new Scanner(System.in);
		Scanner book = new Scanner(System.in);
		Scanner bookPrice = new Scanner(System.in);
		int ch = 0;
		do {
			System.out.println("1.Add Book");
			System.out.println("2.Display ALL");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("Enter your Choice :");
			ch = s.nextInt();
			
			switch(ch) {
				case 1:
//					System.out.print("Enter Book ID:" );
					
					try {
						for(int i=1;i<=3;i++) {
							String bookId=Book.getBookID();
//							Book.getPrice(price);
							System.out.print("Enter BooK Author:" );
							String author = book.nextLine();
							
							System.out.print("Enter Book Title:" );
							String title = book.nextLine();
							
//							System.out.print("Enter Book Category:" );
//							String category = book.nextLine();
							String category = Book.getCategory();
							
//							System.out.print("Enter Book Price:" );
//							float price= bookPrice.nextFloat();
							float price = Book.getPrice();
							
							
							bookCollection.add(new Book(bookId,author,title,category,price));
						}
					}
					catch(Exception e) {
						System.out.println("Exception occurered : "+e);
					}
				
				break;
				case 2:
					System.out.println("------------------------------------------");
					System.out.println("BookId|Author|Title|Category|Price");
					System.out.println("------------------------------------------");
//					System.out.print(bookCollection);
					// Iterator is a function which can show the Record one by one
					//this iterator function having an object Book;
					Iterator<Book> i = bookCollection.iterator();
					while(i.hasNext()) {
						Book b=i.next();
						System.out.println(b);
					}
					System.out.println("------------------------------------------");
				break;
				case 3:
					boolean found= false;
					System.out.println("Enter Book Title to Serach");
					String title = book.nextLine();
					System.out.println("------------------------------------------");
					
//					for(Book data :bookCollection) {
//						if(data.contains == title) {
//							System.out.println(data);
//							found=true;
//						}
//					}
					i = bookCollection.iterator();
					while(i.hasNext()) {
						Book b=i.next();
						if(b.getTitle() == title) {
						System.out.println(b);
						found=true;
						}
					}
					if(!found) {
						System.out.println("Record Not Found");
					}
					System.out.println("------------------------------------------");
				break;
				case 4:
					found= false;
					System.out.println("Enter Book Title to Delete");
					 title = book.nextLine();
					System.out.println("------------------------------------------");
					i = bookCollection.iterator();
					while(i.hasNext()) {
						Book b=i.next();
						if(b.getTitle() == title) {
						i.remove();
						found=true;
						}
					}
					if(!found) {
						System.out.println("Record Not Found");
					}else {
						System.out.println("Record is Deleted successfully");
					}
					System.out.println("------------------------------------------");
				break;
			}
		}while(ch!=0);


	}

}
