/**
 * 
 */
package com.moneyvalue.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author chakra
 *
 */
public class AccountTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.moneyvalue.domain.Account#Account(com.moneyvalue.domain.Transaction[], int, java.lang.String, double)}.
	 */
	@Test
	public void testAccount() {
		Credit[] trans = null;

		
		Account newAccount = new Account(1, "my test account", null, 10.99);
		System.out.println(newAccount);
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.moneyvalue.domain.Account#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
