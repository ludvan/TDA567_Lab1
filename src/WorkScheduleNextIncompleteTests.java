import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkScheduleNextIncompleteTests {
	
	private WorkSchedule ws1;
	private String worker;
	private String worker2;
	
	@BeforeEach
	void setUp() throws Exception {
		ws1 = new WorkSchedule(24);
		worker = "Ludvig";
		worker2 = "G-man";
	}

	@AfterEach
	void tearDown() throws Exception {
		ws1 = null;
	}

	@Test
	void workingEmployeesLessThannEmployee() {
		ws1.setRequiredNumber(2, 0, 23);
		ws1.addWorkingPeriod(worker, 0, 23);
		ws1.addWorkingPeriod(worker2, 0, 5);
		int time = ws1.nextIncomplete(0);
		assertEquals(6, time);
	}

	@Test
	void workingEmployeesGreatherThannEmployee() {
		ws1.setRequiredNumber(1, 0, 23);
		ws1.addWorkingPeriod(worker, 0, 23);
		int time = ws1.nextIncomplete(0);
		assertEquals(-1, time);
	}
	
	@Test
	void currentTimeIncomplete() {
		ws1.setRequiredNumber(2, 2, 23);
		ws1.addWorkingPeriod(worker, 0, 23);
		int time = ws1.nextIncomplete(9);
		assertEquals(2, time);
	}
	
}
