package org.cap.product.test;

import static org.junit.Assert.*;

import org.cap.dao.ProductDao;
import org.cap.dto.Product;
import org.cap.exception.InvalidProductQuanityException;
import org.cap.service.ProductService;
import org.cap.service.ProductServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ProductTestApp {
	
	@Mock
	private ProductDao productdao;
	
	private ProductService productService;
	
	@BeforeClass
	public static void setUpMethod(){
		System.out.println("setUpMethod");
	}
	
	@AfterClass
	public static void tearDownMethod(){
		System.out.println("tearDownMethod");
	}

	@Before
	public void beforeTestCase(){
		System.out.println("BeforeTestCase");
		MockitoAnnotations.initMocks(this);
		productService=new ProductServiceImpl(productdao);
	}
	
	@After
	public void afterTestCase(){
		System.out.println("AfterTestCase");
	}
	
	@Category(GoodTestCategory.class)
	@Test(expected=IllegalArgumentException.class)
	public void addPrduct_check_product_null_value() throws InvalidProductQuanityException{
		System.out.println("addPrduct_check_product_null_value");
		Product product=null;
		productService.addProduct(product);
		
	}
	
	@Test(timeout=100000)
	public void testTimeOut(){
		System.out.println("testTimeOut");
		long sum=0;
		for(long i=0;i<100000000000l;i++)
			sum=sum+i;
	}
	
	@Test
	public void find_product_by_id() {
		Product product = new Product();
		product.setProductId(122);
		product.setProductName("testproduct");
		Mockito.when(productdao.findProduct(122)).thenReturn(product);
		//invoke real mock
		Product product2 = productService.findProduct(122);
		Mockito.verify(productdao).findProduct(122);
		assertEquals(product2.getProductId(), product.getProductId());
	}
	
	/*@Test
	public void verify_consumer() throws InvalidProductQuanityException {
		Product product = new Product();
		product.setProductId(122);
		product.setProductName("testproduct");
		product.setQty(4);
		Mockito.when(productdao.consumeProduct(122,4)).thenReturn(product);
		Product product1 = productdao.consumeProduct(122,4);
		Mockito.verify(productdao).findProduct(122);
		assertEquals(122, product1.getProductId());
	}*/

}
