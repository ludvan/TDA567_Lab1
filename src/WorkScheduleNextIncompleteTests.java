import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkScheduleNextIncompleteTests {
	
	private WorkSchedule ws1;
	private String worker;
	
	@BeforeEach
	void setUp() throws Exception {
		ws1 = new WorkSchedule(24);
		worker = "Ludvig";
	}

	@AfterEach
	void tearDown() throws Exception {
		ws1 = null;
	}

	@Test
	void workingEmployeesLessThannEmployee() {
		ws1.setRequiredNumber(2, 9, 11);
		ws1.addWorkingPeriod(worker, 0, 23);
		int time = ws1.nextIncomplete(0);
		assertEquals(9, time);
	}

	@Test
	void workingEmployeesGreatherThannEmployee() {
		ws1.setRequiredNumber(1, 9, 11);
		ws1.addWorkingPeriod(worker, 0, 23);
		int time = ws1.nextIncomplete(0);
		assertEquals(-1, time);
	}
	
	@Test
	void currentTimeIncomplete() {
		ws1.setRequiredNumber(2, 9, 11);
		ws1.addWorkingPeriod(worker, 0, 23);
		int time = ws1.nextIncomplete(9);
		assertEquals(9, time);
	}
	
}
