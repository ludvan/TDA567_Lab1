import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhiteBoxIntersectTests {
	
	private Set a;
	private Set b;
	private Set c;
	private Set d;
	private int[] ABres = {1};
	private int[] ACDres = {};


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
		c = new Set();
		c.insert(7);
		c.insert(8);
		d = new Set();
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
		assertTrue(arrayEqual(a.toArray(), ABres));
	}
	
	@Test
	void noCommonElements() {
		a.intersect(c);
		assertTrue(arrayEqual(a.toArray(), ACDres));
	}
	
	@Test
	void noElements() {
		a.intersect(c);
		assertTrue(arrayEqual(a.toArray(), ACDres));
	}

}
