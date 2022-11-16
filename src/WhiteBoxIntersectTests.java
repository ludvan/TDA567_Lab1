import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhiteBoxIntersectTests {
	
	private Set a;
	private Set b;
	private int[] res = {1};

	@BeforeEach
	void setUp() throws Exception {
		a = new Set();
		a.insert(1);
		a.insert(2);
		a.insert(6);
		b = new Set();
		b.insert(1);
		b.insert(4);
		b.insert(5);
	}
	
	
	boolean arrayEqual(int[] a, int[] b) {
		if(a.length != b.length) return false;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
	}

	/**
	 * This test has both statement coverage and branch coverage
	 */
	@Test
	void statementAndBranchCoverage() {
		a.intersect(b);
		assertTrue(arrayEqual(a.toArray(), res));
		
	}

}
