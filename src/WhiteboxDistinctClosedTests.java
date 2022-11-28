import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntBinaryOperator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhiteboxDistinctClosedTests {
	
	private Set set;
	private IntBinaryOperator addition;
	private IntBinaryOperator subtraction;
	private IntBinaryOperator division;

	@BeforeEach
	void setUp() throws Exception {
		set = new Set();
		addition = (a,b) -> {
			return a + b;
		};
		subtraction = (a,b) -> {
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
	void testTwoIteratesAddition() {
		set.insert(1);
		set.insert(2);
		assertFalse(set.distinctClosed(addition));
	}
	
	@Test
	void testReturnTrueSubtraction() {
		assertTrue(set.distinctClosed(subtraction));
	}
	
	@Test
	void testIterateSubtraction() {
		set.insert(1);
		assertTrue(set.distinctClosed(subtraction));
	}
	
	@Test
	void testReturnFalseSubtraction1() {
		set.insert(0);
		set.insert(1);
		assertFalse(set.distinctClosed(subtraction));
	}
	
	@Test 
	void testReturnFalseSubtraction2(){
		set.insert(-1);
		set.insert(0);
		assertFalse(set.distinctClosed(subtraction));
	}

}
