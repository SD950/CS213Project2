package proj2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InternationalTest {

	@Test
	public void testTuitionDue() {
		International intlCase1 = new International("Lily",Major.CS,12,true);
		Student studentCase1 = new Student("John",Major.EE,18);
		studentCase1.calculated();
		assertEquals(studentCase1.get_DueTuition(),0.0,0.1);
		Student studentCase2 = new Student("Jake",Major.CS,1);
		studentCase1.calculated();
		assertEquals(studentCase2.get_DueTuition(),0.0,12);
		intlCase1.calculated();
		assertEquals(intlCase1.get_DueTuition(),0.0,14);
	}

}
