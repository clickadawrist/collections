package edu.ncsu.csc216.cash_register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests CashRegister Class
 * @author SarahHeckman
 */
public class CashRegisterTest {
	
	private CashRegister register;

	/**
	 * Setups up the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		register = new CashRegister();
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CashRegister#getCurrentBalance()}.
	 */
	@Test
	public void testGetCurrentBalance() {
		//Test that we start with $3641 in the drawer
		assertEquals("hint: CashRegister.getCurrentBalance() - check initial balance", 36410, register.getCurrentBalance());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CashRegister#processPurchase(int, edu.ncsu.csc216.cash_register.CurrencyCollection)}.
	 */
	@Test
	public void testProcessPurchase() {
		//Test that we throw exception if customer doesn't pay enough
		CurrencyCollection c = new CurrencyCollection();
		c.modifyDenomination(CurrencyCollection.TWENTY_VALUE, 2);
		c.modifyDenomination(CurrencyCollection.FIVE_VALUE, 1);
		c.modifyDenomination(CurrencyCollection.ONE_VALUE, 2);
		try {
			register.processPurchase(5000, c);
			fail("hint: CashRegister.processPurchase() - cannot purchase an item when you don't have enough money");
		} catch (IllegalArgumentException e) {
			assertEquals("hint: CashRegister.processPurchase() - check that balance is the same if can't make a purchase", 36410, register.getCurrentBalance());
		}
		
		//Deposit enough money to pay
		c.modifyDenomination(CurrencyCollection.ONE_VALUE, 3);
		CurrencyCollection refund = register.processPurchase(5000, c);
		assertEquals("hint: CashRegister.processPurchase() - check of balance after a refund", 41410, register.getCurrentBalance());
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getBalance());
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[0].getCount()); //Pennies
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[1].getCount()); //Nickels
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[2].getCount()); //Dimes
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[3].getCount()); //Quarters
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[4].getCount()); //Dollars
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[5].getCount()); //Five Dollars
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[6].getCount()); //Ten Dollars
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[7].getCount()); //Twenty Dollars
		
		//Deposit more money to pay and ensure change is correct
		c.modifyDenomination(CurrencyCollection.ONE_VALUE, 3);
		c.modifyDenomination(CurrencyCollection.QUARTER_VALUE, 3);
		c.modifyDenomination(CurrencyCollection.DIME_VALUE, 1);
		c.modifyDenomination(CurrencyCollection.PENNY_VALUE, 4);
		refund = register.processPurchase(5000, c);
		assertEquals("hint: CashRegister.processPurchase() - check of balance after a refund", 46410, register.getCurrentBalance());
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 389, refund.getBalance());
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 4, refund.getCurrencyCollection()[0].getCount()); //Pennies
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[1].getCount()); //Nickels
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 1, refund.getCurrencyCollection()[2].getCount()); //Dimes
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 3, refund.getCurrencyCollection()[3].getCount()); //Quarters
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 3, refund.getCurrencyCollection()[4].getCount()); //Dollars
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[5].getCount()); //Five Dollars
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[6].getCount()); //Ten Dollars
		assertEquals("hint: CashRegister.processPurchase() - check of change after purchase", 0, refund.getCurrencyCollection()[7].getCount()); //Twenty Dollars
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CashRegister#processRefund(int)}.
	 */
	@Test
	public void testProcessRefund() {
		//Process a refund of $1.00
		CurrencyCollection refund = register.processRefund(100);
		CurrencyCollection expected = new CurrencyCollection();
		expected.modifyDenomination(CurrencyCollection.ONE_VALUE, 1);
		assertEquals("hint: CashRegister.processRefund() - incorrect refund balance", expected.getBalance(), refund.getBalance());
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			assertEquals("hint: CashRegister.processRefund() - incorrect count of denominations at index " + i, expected.getCurrencyAtIdx(i).getCount(), refund.getCurrencyAtIdx(i).getCount());
		}
		assertEquals("hint: CashRegister.processRefund() - incorrect register balance after refund", 36310, register.getCurrentBalance());
		
		//Refund all the money in the register
		//Reset the register
		register = new CashRegister();
		refund = register.processRefund(36410);
		assertEquals("hint: CashRegister.processRefund() - incorrect register balance after refund", 0, register.getCurrentBalance());
		assertEquals("hint: CashRegister.processRefund() - incorrect refund balance", 36410, refund.getBalance());
		for (int i = 0; i < CurrencyCollection.NUM_SLOTS; i++) {
			assertEquals("hint: CashRegister.processRefund() - incorrect count in refund - " + refund.getCurrencyAtIdx(i).getName(), 10, refund.getCurrencyAtIdx(i).getCount()); 
		}
	}

}