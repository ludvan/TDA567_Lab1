import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntBinaryOperator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhiteboxDistinctClosedTests {
	
	private Set set;
	private IntBinaryOperator addition;
	private IntBinaryOperator substraction;

	@BeforeEach
	void setUp() throws Exception {
		set = new Set();
		addition = (a,b) -> {
			return a + b;
		};
		
		substraction = (a,b) -> {
			return a - b;
		};
	}

	@AfterEach
	void tearDown() throws Exception {
		set = null;
	}

	@Test
	void testReturnTrueAddition() {
		assertTrue(set.distinctClosed(addition));
	}
	
	@Test
	void testIterateAddition() {
		set.insert(1);
		assertTrue(set.distinctClosed(addition));
	}
	
	@Test
	void test() {
		set.insert(1);
		set.insert(2);
		assertFalse(set.distinctClosed(addition));
	}

}
