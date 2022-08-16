package com.techment.bookutil;

public class InvalidNegativePriceException extends Exception{
	public InvalidNegativePriceException(String str) {
		super(str);
	}
}
