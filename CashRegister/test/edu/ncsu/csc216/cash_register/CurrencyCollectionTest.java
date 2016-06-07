/**
 * 
 */
package edu.ncsu.csc216.cash_register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for the CurrencyCollection class
 * @author SarahHeckman
 */
public class CurrencyCollectionTest {
	
	private CurrencyCollection currency;

	/**
	 * Sets up before each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		currency = new CurrencyCollection();
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#CurrencyCollection()}.
	 */
	@Test
	public void testCurrencyCollection() {
		//Test that the default constructor (used in setup) has no balance
		assertEquals("hint: CurrencyCollection.CurrencyCollection() - test default balance of CurrencyCollection", 0, currency.getBalance());
		
		//Test that refunding leaves the same balance
		try {
			currency.refundByAmount(20);
			fail("hint: CurrencyCollection.CurrencyCollection() - attempted to refund currency when no balance");
		} catch (IllegalArgumentException e) {
			assertEquals("hint: CurrencyCollection.CurrencyCollection() - an attempt to refund should not change the balance", 0, currency.getBalance());
		}
		
		//Test that adding currency gives a new balance
		currency.depositCurrencyCollection(new CurrencyCollection(1));
		
		assertEquals("hint: CurrencyCollection.CurrencyCollection() - did not accept a deposit of $3641", 3641, currency.getBalance());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#CurrencyCollection(int)}.
	 */
	@Test
	public void testCurrencyCollectionInt() {
		currency = new CurrencyCollection(1);
		assertEquals("hint: CurrencyCollection.CurrencyCollection(int) - constructing a CurrencyCollection with a parameter of 1 does not result in a balance of $3641", 3641, currency.getBalance());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		//Test that if use default constructor the balance is 0
		assertEquals("hint: CurrencyCollection.getBalance() - test default balance of CurrencyCollection", 0, currency.getBalance());
		
		//Test balance of penny
		currency.modifyDenomination(CurrencyCollection.PENNY_VALUE, 1);
		assertEquals("hint: CurrencyCollection.getBalance() - add a penny", 1, currency.getBalance());
				
		//Test balance of penny + nickel
		currency.modifyDenomination(CurrencyCollection.NICKEL_VALUE, 1);
		assertEquals("hint: CurrencyCollection.getBalance() - add a nickle (after adding a penny)", 6, currency.getBalance());
		
		//Test balance of penny + nickel + dollar
		currency.modifyDenomination(CurrencyCollection.ONE_VALUE, 1);
		assertEquals("hint: CurrencyCollection.getBalance() - add a dollar (after adding a penny and nickle)", 106, currency.getBalance());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#getCurrencyAtInx()}.
	 */
	@Test
	public void testGetCurrencyAtIdx() {
		String [] names = {CurrencyCollection.PENNY_NAME, CurrencyCollection.NICKEL_NAME, CurrencyCollection.DIME_NAME,
				CurrencyCollection.QUARTER_NAME, CurrencyCollection.ONE_NAME, CurrencyCollection.FIVE_NAME,
				CurrencyCollection.TEN_NAME, CurrencyCollection.TWENTY_NAME
		};
		int [] values = {CurrencyCollection.PENNY_VALUE, CurrencyCollection.NICKEL_VALUE, CurrencyCollection.DIME_VALUE,
				CurrencyCollection.QUARTER_VALUE, CurrencyCollection.ONE_VALUE, CurrencyCollection.FIVE_VALUE,
				CurrencyCollection.TEN_VALUE, CurrencyCollection.TWENTY_VALUE
		};
		int [] counts = {3, 1, 2, 3, 4, 10, 1, 0};
		
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			Currency c = currency.getCurrencyAtIdx(i);
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected name = " + names[i], names[i], c.getName());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected value = " + values[i], values[i], c.getValue());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected count = " + 0, 0, c.getCount());
		}

		CurrencyCollection deposit = new CurrencyCollection();
		for (int i = 0; i < values.length; i++) {
			deposit.modifyDenomination(values[i], counts[i]);
		}
		
		currency.depositCurrencyCollection(deposit);
		
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			Currency c = currency.getCurrencyAtIdx(i);
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected name = " + names[i], names[i], c.getName());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected value = " + values[i], values[i], c.getValue());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected count = " + counts[i], counts[i], c.getCount());
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#modifyDenomination()}.
	 */
	@Test
	public void testModifyDenomination() {
		//Test adding a valid denomination
		currency.modifyDenomination(CurrencyCollection.PENNY_VALUE, 3);
		assertEquals("hint: CurrencyCollection.modifyDenomination() - expected balance = 3 - actual balance = " + currency.getBalance(), 3, currency.getBalance());
		assertEquals("hint: CurrencyCollection.modifyDenomination() - expected count = 3 - actual count = " + currency.getCurrencyAtIdx(0).getCount(), 3, currency.getCurrencyAtIdx(0).getCount());
		
		//Test removing a valid denomination
		currency.modifyDenomination(CurrencyCollection.PENNY_VALUE, -2);
		assertEquals("hint: CurrencyCollection.modifyDenomination() - expected balance = 1 - actual balance = " + currency.getBalance(), 1, currency.getBalance());
		assertEquals("hint: CurrencyCollection.modifyDenomination() - expected count = 1 - actual count = " + currency.getCurrencyAtIdx(0).getCount(), 1, currency.getCurrencyAtIdx(0).getCount());
		
		//Test an invalid denomination value
		try {
			currency.modifyDenomination(7, 3);
			fail("hint: CurrencyCollection.modifyDenomination() - cannot modify a denomination with an invalid value");
		} catch (IllegalArgumentException e) {
			assertEquals("hint: CurrencyCollection.modifyDenomination() - expected balance = 1 - actual balance = " + currency.getBalance(), 1, currency.getBalance());
			assertEquals("hint: CurrencyCollection.modifyDenomination() - expected count = 1 - actual count = " + currency.getCurrencyAtIdx(0).getCount(), 1, currency.getCurrencyAtIdx(0).getCount());
			
			for (int i = 1; i < CurrencyCollection.NUM_SLOTS; i++) {
				assertEquals("hint: CurrencyCollection.modifyDenomination() - expected count = 0 - actual count = " + currency.getCurrencyAtIdx(i).getCount(), 0, currency.getCurrencyAtIdx(i).getCount());
			}
		}
		
		//Test removing too much denomination
		try {
			currency.modifyDenomination(CurrencyCollection.PENNY_VALUE, -2);
			fail("hint: CurrencyCollection.modifyDenomination() - cannot remove more currency than exists");
		} catch (IllegalArgumentException e) {
			assertEquals("hint: CurrencyCollection.modifyDenomination() - expected balance = 1 - actual balance = " + currency.getBalance(), 1, currency.getBalance());
			assertEquals("hint: CurrencyCollection.modifyDenomination() - expected count = 1 - actual count = " + currency.getCurrencyAtIdx(0).getCount(), 1, currency.getCurrencyAtIdx(0).getCount());
			
			for (int i = 1; i < CurrencyCollection.NUM_SLOTS; i++) {
				assertEquals("hint: CurrencyCollection.modifyDenomination() - expected count = 0 - actual count = " + currency.getCurrencyAtIdx(i).getCount(), 0, currency.getCurrencyAtIdx(i).getCount());
			}
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#depositCurrencyCollection()}.
	 */
	@Test
	public void testDepositCurrencyCollection() {
		String [] names = {CurrencyCollection.PENNY_NAME, CurrencyCollection.NICKEL_NAME, CurrencyCollection.DIME_NAME,
				CurrencyCollection.QUARTER_NAME, CurrencyCollection.ONE_NAME, CurrencyCollection.FIVE_NAME,
				CurrencyCollection.TEN_NAME, CurrencyCollection.TWENTY_NAME
		};
		int [] values = {CurrencyCollection.PENNY_VALUE, CurrencyCollection.NICKEL_VALUE, CurrencyCollection.DIME_VALUE,
				CurrencyCollection.QUARTER_VALUE, CurrencyCollection.ONE_VALUE, CurrencyCollection.FIVE_VALUE,
				CurrencyCollection.TEN_VALUE, CurrencyCollection.TWENTY_VALUE
		};
		int [] counts = {1, 2, 3, 4, 5, 6, 7, 0};
				
		CurrencyCollection deposit = new CurrencyCollection();
		for (int i = 0; i < values.length; i++) {
			deposit.modifyDenomination(values[i], counts[i]);
		}
		
		currency.depositCurrencyCollection(deposit);
		
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			Currency c = currency.getCurrencyAtIdx(i);
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected name = " + names[i], names[i], c.getName());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected value = " + values[i], values[i], c.getValue());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected count = " + counts[i], counts[i], c.getCount());
		}
		
		int [] counts2 = {1, 2, 3, 4, 5, 6, 7, 8};
		int [] totalCounts = {2, 4, 6, 8, 10, 12, 14, 8};
		
		CurrencyCollection deposit2 = new CurrencyCollection();
		for (int i = 0; i < values.length; i++) {
			deposit2.modifyDenomination(values[i], counts2[i]);
		}
		
		currency.depositCurrencyCollection(deposit2);
		
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			Currency c = currency.getCurrencyAtIdx(i);
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected name = " + names[i], names[i], c.getName());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected value = " + values[i], values[i], c.getValue());
			assertEquals("hint: CurrencyCollection.getCurrencyAtIdx() - idx = " + i + " - expected count = " + totalCounts[i], totalCounts[i], c.getCount());
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#refundByAmount()}.
	 */
	@Test
	public void testRefundByAmount() {
		//Test that cannot refund on empty collection
		CurrencyCollection refund = null;
		try {
			refund = currency.refundByAmount(2000);
			fail("hint: CurrencyCollection.refundByAmount() - cannot refund if insuffient balance in collection");
		} catch (IllegalArgumentException e) {
			assertNull("hint: CurrencyCollection.refundByAmount() - refund was generated when insuffient balance in collection", refund);
		}
		
		//Test refunding exact amount in the cash register
		currency.modifyDenomination(CurrencyCollection.TWENTY_VALUE, 1);
		refund = currency.refundByAmount(2000);

		int [] currencyCount1 = {0, 0, 0, 0, 0, 0, 0, 0};
		int [] refundCount1 = {0, 0, 0, 0, 0, 0, 0, 1};
		
		String [] names = {CurrencyCollection.PENNY_NAME, CurrencyCollection.NICKEL_NAME, CurrencyCollection.DIME_NAME,
				CurrencyCollection.QUARTER_NAME, CurrencyCollection.ONE_NAME, CurrencyCollection.FIVE_NAME,
				CurrencyCollection.TEN_NAME, CurrencyCollection.TWENTY_NAME
		};
		
		assertEquals("hint: CurrencyCollection.refundByAmount() - balance should be 0 after refunding full amount in collection", 0, currency.getBalance());
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			assertEquals("hint: CurrencyCollection.refundByAmount() - " + names[i] + " should have count of 0 after full refund", currencyCount1[i], currency.getCurrencyAtIdx(i).getCount());
		}
		assertEquals("hint: CurrencyCollection.refundByAmount() - balance should be 2000 in refunded collection", 2000, refund.getBalance());
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			assertEquals("hint: CurrencyCollection.refundByAmount() - " + names[i] + " should have count of " + refundCount1[i] + " in refunded collection", refundCount1[i], refund.getCurrencyAtIdx(i).getCount());
		}
		
		//Test refunding one of each denomination
		int [] values = {CurrencyCollection.PENNY_VALUE, CurrencyCollection.NICKEL_VALUE, CurrencyCollection.DIME_VALUE,
				CurrencyCollection.QUARTER_VALUE, CurrencyCollection.ONE_VALUE, CurrencyCollection.FIVE_VALUE,
				CurrencyCollection.TEN_VALUE, CurrencyCollection.TWENTY_VALUE
		};
		
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			currency.modifyDenomination(values[i], 11);
		}
		refund = currency.refundByAmount(3641);

		int [] currencyCount2 = {10, 10, 10, 10, 10, 10, 10, 10};
		int [] refundCount2 = {1, 1, 1, 1, 1, 1, 1, 1};
		
		assertEquals("hint: CurrencyCollection.refundByAmount() - balance should be 36410 after refunding full amount in collection", 36410, currency.getBalance());
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			assertEquals("hint: CurrencyCollection.refundByAmount() - " + names[i] + " should have count of 10 after full refund", currencyCount2[i], currency.getCurrencyAtIdx(i).getCount());
		}
		assertEquals("hint: CurrencyCollection.refundByAmount() - balance should be 3641 in refunded collection", 3641, refund.getBalance());
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			assertEquals("hint: CurrencyCollection.refundByAmount() - " + names[i] + " should have count of " + refundCount2[i] + " in refunded collection", refundCount2[i], refund.getCurrencyAtIdx(i).getCount());
		}
		
		//Test unable to refund because not exact change
		refund = null;
		currency.modifyDenomination(CurrencyCollection.PENNY_VALUE, -8);
		try {
			refund = currency.refundByAmount(3);
			fail("hint: CurrencyCollection.refundByAmount() - cannot refund if not exact change");
		} catch (IllegalArgumentException e) {
			assertNull("hint: CurrencyCollection.refundByAmount() - refund was generated when there is not exact change in the collection", refund);
		}
	}

}
