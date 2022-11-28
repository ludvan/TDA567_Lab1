import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkingEmployeesTest {
	
	private WorkSchedule ws;
	private String employee;
	private String employee2;
	private String[] workingEmployees;

	@BeforeEach
	void setUp() throws Exception {
		ws = new WorkSchedule(24);
		employee = "Ludwig";
		employee2 = "Isak";
		workingEmployees = new String[2];
		workingEmployees[0] = employee;
		workingEmployees[1] = employee2;
	}

	@AfterEach
	void tearDown() throws Exception {
		ws = null;
		employee = null;
		employee2 = null;
	}

	/* Partition 9
	 * Test for workingEmployee > nemployee
	 */
	@Test
	void testWorkingandnEmployee() {
		
	}
	
	/* Partition 10
	 * Test for workingEmployee <= nemployee
	 */
	@Test
	void testWorkingandnEmployee2() {
		
	}

}
