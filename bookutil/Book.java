package com.techment.bookutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.techmen.exception.InvalidCategory;
import com.techmen.exception.InvalidNegativePrice;

import com.techment.bookutil.InvalidIDException;

public class Book {

	String bookId,author,title,category;
	float price;
	
	Book(String bookId,String author,String title,String category,float price){
		this.bookId=bookId;
		this.title=title;
		this.author=author;
		this.category=category;
		this.price=price;
	}
	
//	public String getBookID() {
//		return bookId;
//	}
//	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
//	
//	public String getCategory() {
//		return category;
//	}
//	
//	public float getPrice() {
//		return price;
//	}
	
	public String toString() {
		return bookId+" "+author+" "+title+" "+category+" "+price;
	}

//	validations for bookID
	public static String getBookID() throws InvalidIDException {
		Scanner myObj = new Scanner(System.in); //create scanner obj
		System.out.print("Enter Book ID : ");
		//String Input
		String bookId = myObj.nextLine();
		if(!bookId.startsWith("B")) {
			throw new InvalidIDException("ID is not valid ,BookID Should start with B ");
		}
		else {
//			System.out.println("BookID is correct");
			return bookId;
		}
		
	}
	
	//validations for category
	public static String getCategory() throws InvalidCategoryException {
		List categoryList = new ArrayList();
		categoryList.add("science");
		categoryList.add("friction");
		categoryList.add("technology");
		categoryList.add("other");
		
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter Category :");
		String category = myObj.nextLine();
		
		if(!categoryList.contains(category)) {
			throw new InvalidCategoryException("Category not match CAtegory Should be like Science,Friction,Technology,Others");	
		}else {
//			System.out.println("Category Correct");
			return category;
		}
	}
	
	//validations for price
	
	public static float getPrice() throws InvalidNegativePriceException{
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter Price : ");
		float price = myObj.nextFloat();
		
		if(price <= 0) {
			throw new InvalidNegativePriceException("Price Should be Positive");
		}else {
//			System.out.println("Price is Correct");
			return price;
		}
	}
}	



