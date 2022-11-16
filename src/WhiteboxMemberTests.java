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
		set.insert(3);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void ExistsInSet() {
		assertTrue(set.member(2));
	}
	
	@Test
	void NotExistsInSet() {
		assertFalse(set.member(4));	
	}

}
