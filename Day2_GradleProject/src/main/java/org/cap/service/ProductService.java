package org.cap.service;

import org.cap.dto.Product;
import org.cap.exception.InvalidProductQuanityException;

public interface ProductService {
	
	public Product addProduct(Product product)throws InvalidProductQuanityException;
	
	public Product findProduct(int productId);
	
	public Product consumeProduct(int productId,int qty)throws InvalidProductQuanityException;
	
	public Product produceProduct(int productId,int qty);
}
