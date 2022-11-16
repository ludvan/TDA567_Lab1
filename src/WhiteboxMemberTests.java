import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhiteboxMemberTests {
	
	private Set set;

	@BeforeEach
	void setUp() throws Exception {
		set = new Set();
		set.insert(1);
		set.insert(2);
		set.insert(5);
	}

	/*
	 * Tests all statements except return false
	 */
	@Test
	void ExistsInSet() {
		assertTrue(set.member(2));
	}
	
	/*
	 * Tests all statements except return true, also tests branch i>=a.size
	 */
	@Test
	void LargerThanSet() {
		assertFalse(set.member(6));	
	}
	/*
	 * Tests all statements except return true, also tests branch a.get(i)>x
	 */
	@Test
	void MissingWithinSet() {
		assertFalse(set.member(4));	
	}

}
