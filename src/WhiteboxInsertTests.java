import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhiteboxInsertTests {
	
	private Set set;
	
	@BeforeEach
	void setUp() {
		set = new Set();
	}

	@Test
	void ascendingOrder() {
		int[] temp = new int[] {1,2,3};
		set.insert(1);
		set.insert(2);
		set.insert(3);
		assertArrayEquals(temp, set.toArray());
	}
	
	@Test
	void descendingOrder() {
		int[] temp = new int[] {1,2,3};
		set.insert(3);
		set.insert(2);
		set.insert(1);
		System.out.println(set.toArray());
		assertArrayEquals(temp, set.toArray());
	}
	
	@Test
	void addingDuplicate() {
		int[] temp = new int[] {1};	
		set.insert(1);
		set.insert(1);
		System.out.println(set.toArray());
		assertArrayEquals(temp, set.toArray());
	}

}
