package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class MoneyTest {
	private IMoney m12CHF;  
	private IMoney m14CHF;
	
	
	@Before
	public void setUp() {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
	}
	
	@Test
	public void testSimpleAdd() {
		IMoney expected = new Money(26, "CHF");
		IMoney result = m12CHF.add(m14CHF); // exécution de la méthode testée
		assertTrue(expected.equals(result)); // comparaison
	}
	
	@Test
	public void testEquals() {
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF); 
		assertEquals(m12CHF, new Money(12, "CHF")); 
		assertTrue(!m12CHF.equals(m14CHF));
	}
	
	

}
