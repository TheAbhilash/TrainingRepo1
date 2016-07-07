package org.cap.product.test;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(Theories.class)
public class MyTheoryClass {

	private int a,b;
	
	public MyTheoryClass(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@DataPoints
	public static int[] inputData() {
		return new int[] {-1,2,0,-5,3,5,12};
	}
	
	@Theory
	public void testMyTheory(int a, int b) {
		System.out.println(a + ","+b);
		Assume.assumeTrue(a>0 && b>0);
		assertTrue(a+b == b+a);
	}
}
