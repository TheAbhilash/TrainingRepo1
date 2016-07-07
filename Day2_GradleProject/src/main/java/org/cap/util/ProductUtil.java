package org.cap.util;

public class ProductUtil {
	
	private static int id=0;
	
	public static int generateProductId(){
		return id++;
	}

}
