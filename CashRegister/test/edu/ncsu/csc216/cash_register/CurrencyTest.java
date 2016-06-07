/**
 * 
 */
package edu.ncsu.csc216.cash_register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for the Currency class.
 * @author SarahHeckman
 */
public class CurrencyTest {
	private Currency penny;
	private Currency dollar;

	/**
	 * Sets up before each test
	 */
	@Before
	public void setUp() throws Exception {
		penny = new Currency(CurrencyCollection.PENNY_VALUE, CurrencyCollection.PENNY_NAME, 10);
		dollar = new Currency(CurrencyCollection.ONE_VALUE, CurrencyCollection.ONE_NAME, 10);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#getValue()}.
	 */
	@Test
	public void testGetValue() {
		assertEquals("hint: Currency.getValue() - fix Currency.getValue() when Currency represents a penny", CurrencyCollection.PENNY_VALUE, penny.getValue());
		assertEquals("hint: Currency.getValue() - fix Currency.getValue() when Currency represents a dollar", CurrencyCollection.ONE_VALUE, dollar.getValue());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("hint: Currency.getName() - fix Currency.getName() when Currency represents a penny", CurrencyCollection.PENNY_NAME, penny.getName());
		assertEquals("hint: Currency.getName() - fix Currency.getName() when Currency represents a dollar", CurrencyCollection.ONE_NAME, dollar.getName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#getCount()}.
	 */
	@Test
	public void testGetCount() {
		assertEquals("hint: Currency.getCount() - expected count - 10; actual count - " + penny.getCount(), 10, penny.getCount());
		assertEquals("hint: Currency.getCount() - expected count - 10; actual count - " + dollar.getCount(), 10, dollar.getCount());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#modifyCount(int)}.
	 * 
	 * The test uses the getCount() method to understand how the 
	 * count is changed when using the increaseCount() method
	 */
	@Test
	public void testModifyCount() {
		assertEquals("hint: Currency.increaseCount() - expected count - 10; actual count - " + penny.getCount(), 10, penny.getCount());
		assertEquals("hint: Currency.increaseCount() - expected count - 10; actual count - " + dollar.getCount(), 10, dollar.getCount());
		
		penny.modifyCount(3);
		
		assertEquals("hint: Currency.increaseCount() - increased count by 3 - expected count - 13; actual count - " + penny.getCount(), 13, penny.getCount());
		assertEquals("hint: Currency.increaseCount() - expected count - 10; actual count - " + dollar.getCount(), 10, dollar.getCount());
		
		dollar.modifyCount(-5);
		dollar.modifyCount(2);
		
		assertEquals("hint: Currency.increaseCount() - expected count - 13; actual count - " + penny.getCount(), 13, penny.getCount());
		assertEquals("hint: Currency.increaseCount() - decreased count by 5, then increased by 2 - expected count - 7; actual count - " + dollar.getCount(), 7, dollar.getCount());
		
		try {
			dollar.modifyCount(-8);
			fail("hint: Currency.decreaseCount() - attempt to decrease by 8 when Currency contains 7");
		} catch (IllegalArgumentException e) {
			assertEquals("hint: Currency.decreaseCount() - expected count - 13; actual count - " + penny.getCount(), 13, penny.getCount());
			assertEquals("hint: Currency.decreaseCount() - expected count - 7; actual count - " + dollar.getCount(), 7, dollar.getCount());
		}
	}

}
