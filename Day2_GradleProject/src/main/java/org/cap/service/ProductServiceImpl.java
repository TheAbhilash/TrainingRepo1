package org.cap.service;

import org.cap.dao.ProductDao;
import org.cap.dao.ProductDaoImpl;
import org.cap.dto.Product;
import org.cap.exception.InvalidProductQuanityException;
import org.cap.util.ProductUtil;

public class ProductServiceImpl implements ProductService{
	
	
	private ProductDao productDao;
	
	public ProductServiceImpl(ProductDao dao){
		//productDao=new ProductDaoImpl();
		this.productDao = dao;
	}
	

	@Override
	public Product addProduct(Product product) throws InvalidProductQuanityException {
		
		if(product==null)
			throw new IllegalArgumentException();
		if(product.getQty()<=0)
			throw new InvalidProductQuanityException();
		
		product.setProductId(ProductUtil.generateProductId());
		
		if(productDao.createProduct(product))
			return product;
		
		return null;
	}

	@Override
	public Product findProduct(int productId) {
		
		return productDao.findProduct(productId);
	}

	@Override
	public Product consumeProduct(int productId,int qty) throws InvalidProductQuanityException {
		
		
		Product product=productDao.findProduct(productId);
		
		if(product.getQty()<qty)
			throw new InvalidProductQuanityException();
			
			product.setQty(product.getQty()-qty);
		
		
		return product;
	}

	@Override
	public Product produceProduct(int productId,int qty) {
		Product product=productDao.findProduct(productId);
			
			product.setQty(product.getQty()+qty);
		return product;
	}

}
