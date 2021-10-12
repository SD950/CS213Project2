package proj2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RosterTest {

	@Test
	public void testAdd() {
		Roster rosterCase1 = new Roster();
		Student studentCase1 = new Student("Lily",Major.CS,12);
		TriState tristate = new TriState("Lily",Major.CS,12,"DE");
		Resident resident = new Resident("Lily",Major.CS,40);
		NonResident nresident = new NonResident("Lily",Major.CS,2);
		International intlstudent = new International("Lily",Major.CS,1,true);
		
		assertTrue(rosterCase1.add(studentCase1));
		assertFalse(rosterCase1.add(tristate));
		assertFalse(rosterCase1.add(resident));
		assertFalse(rosterCase1.add(nresident));
		assertFalse(rosterCase1.add(intlstudent));
	}
	@Test
	public void testRemove() {
		Roster rosterCase1 = new Roster();
		Student studentCase1 = new Student("Lily",Major.CS,12);
		TriState tristate = new TriState("Lily",Major.CS,12,"CT");
		Resident resident = new Resident("Lily",Major.CS,13);
		NonResident nresident = new NonResident("Lily",Major.CS,14);
		International intlstudent = new International("Lily",Major.CS,12,true);
		assertFalse(rosterCase1.remove(studentCase1));
		rosterCase1.add(studentCase1);
		assertTrue(rosterCase1.remove(studentCase1));
		rosterCase1.add(tristate);
		assertTrue(rosterCase1.remove(tristate));
		rosterCase1.add(resident);
		assertTrue(rosterCase1.remove(resident));
		rosterCase1.add(nresident);
		assertTrue(rosterCase1.remove(nresident));
		rosterCase1.add(intlstudent);
		assertTrue(rosterCase1.remove(intlstudent));
	}

}
