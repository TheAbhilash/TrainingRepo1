package org.cap.dao;

import org.cap.dto.Product;

public interface ProductDao {
	
	public boolean createProduct(Product product);
	public Product findProduct(int productId);
	public Product consumeProduct(int productId, int prdQty);
}
