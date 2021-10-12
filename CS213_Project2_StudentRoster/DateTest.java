package proj2;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {

	@Test
	public void testIsValid() {
		Date dateCase1 = new Date("14/11/2026"); // invalid test date because month is too large
		assertFalse(dateCase1.isValid(dateCase1));
		Date dateCase2 = new Date("4/9/1965");// lower than 2021 so fail
		assertFalse(dateCase2.isValid(dateCase2));
		Date dateCase3 = new Date("0/45/2024");//invalid test date because month is too small
		assertFalse(dateCase3.isValid(dateCase3));
		Date dateCase4 = new Date("3/56/2022");// invalid test date because day is too large
		assertFalse(dateCase4.isValid(dateCase4));
		Date dateCase5 = new Date("2/29/2024");// valid test date because leap year **
		assertFalse(dateCase5.isValid(dateCase5));
		Date dateCase6 = new Date("2/29/2022");// invalid test date because not a leap year
		assertFalse(dateCase6.isValid(dateCase6));
		Date dateCase7 = new Date("5/0/2027");//invalid because month is too small
		assertFalse(dateCase7.isValid(dateCase7));
		Date dateCase8 = new Date();//test today's date valid
		assertTrue(dateCase8.isValid(dateCase8));
		Date dateCase9 = new Date("3/7/2029");//valid test date, future date past 2021 **
		assertFalse(dateCase9.isValid(dateCase9));

}
}
