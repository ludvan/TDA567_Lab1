import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorkScheduleSetRequiredTests {
	
	private WorkSchedule ws;
	private WorkSchedule temp;
	private String employee1;
	private String employee2;
	
	@BeforeEach
	void setUp() throws Exception {
		ws = new WorkSchedule(24);
		employee1 = "Liam";
		employee2 = "Isak";
		temp = new WorkSchedule(24);
	}
	/*
	 * startime > endtime
	 * workingEmployee.length > nemployee
	 */
	@Test
	void startTimeGreaterEndTime() {
		ws.setRequiredNumber(1, 1, 5);
		ws.addWorkingPeriod(employee1, 1, 5);
		temp.setRequiredNumber(1, 1, 5);
		temp.addWorkingPeriod(employee1, 1, 5);
		
		//This call to setRequiredNumber should not alter temp at all since starttime is greater than endtime
		temp.setRequiredNumber(0, 3, 1);
		
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h = ws.readSchedule(i);
			WorkSchedule.Hour h2 = temp.readSchedule(i);
			assertTrue(h.requiredNumber == h2.requiredNumber);
			assertTrue(h.workingEmployees.length == h2.workingEmployees.length);
		}
	}
	/*
	 * starttime > endtime
	 * workingEmployee <= nemployee
	 */
	@Test
	void workingEmployeeLesserThanNemployee() {
		ws.setRequiredNumber(1, 1, 5);
		ws.addWorkingPeriod(employee1, 1, 5);
		temp.setRequiredNumber(1, 1, 5);
		temp.addWorkingPeriod(employee1, 1, 5);
		
		//This call to setRequiredNumber should not alter temp at all since starttime is greater than endtime
		temp.setRequiredNumber(2, 3, 1);
		
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h = ws.readSchedule(i);
			WorkSchedule.Hour h2 = temp.readSchedule(i);
			assertTrue(h.requiredNumber == h2.requiredNumber);
			assertTrue(h.workingEmployees.length == h2.workingEmployees.length);
		}
	}
	
	@Test
	/*
	 * workingEmployee.length > nemployee
	 *  endtime >= starttime
	 */
	void endGreaterWorkEmployeeGreater(){
		ws.setRequiredNumber(2, 1, 8);
		ws.addWorkingPeriod(employee1, 1, 8);
		ws.addWorkingPeriod(employee2, 1, 5);
		
		temp.setRequiredNumber(2, 1, 8);
		temp.addWorkingPeriod(employee1, 1, 8);
		temp.addWorkingPeriod(employee2, 1, 5);
		temp.setRequiredNumber(1, 1, 8);
		
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h = temp.readSchedule(i);
			WorkSchedule.Hour h2 = ws.readSchedule(i);
			if(i > 0 && i < 9) {
				assertEquals(1, h.requiredNumber);
				assertEquals(1, h.workingEmployees.length);
			}else {
				assertTrue(h.requiredNumber == h2.requiredNumber);
				assertTrue(h.workingEmployees.length == h2.workingEmployees.length);
				
			}
			
		}
		
	}
	/*
	 * endtime >= starttime
	 * workingemployee <= nemployee
	 */
	@Test
	void endGreaterNemployeeGreater() {
		ws.setRequiredNumber(2, 1, 8);
		ws.addWorkingPeriod(employee1, 1, 8);
		ws.addWorkingPeriod(employee2, 1, 5);
		
		temp.setRequiredNumber(2, 1, 8);
		temp.addWorkingPeriod(employee1, 1, 8);
		temp.addWorkingPeriod(employee2, 1, 5);
		temp.setRequiredNumber(3, 1, 8);
		
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h = temp.readSchedule(i);
			WorkSchedule.Hour h2 = ws.readSchedule(i);
			
			if(i > 0 && i < 9) {
				assertTrue(h.requiredNumber == 3);
			}else {
				assertTrue(h.requiredNumber == h2.requiredNumber);
			}
			assertTrue(h.workingEmployees.length == h2.workingEmployees.length);
			
		}
		
	}
	
	/*
	 * endtime == starttime
	 * 
	 */
	@Test
	void endtimeEqualToStartime() {
		temp.setRequiredNumber(1, 3, 3);
		temp.addWorkingPeriod(employee1, 3, 3);
		temp.addWorkingPeriod(employee2, 3, 3);
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h1 = ws.readSchedule(i);
			WorkSchedule.Hour h2 = temp.readSchedule(i);
			if(i != 3) {
				assertTrue(h1.requiredNumber == h2.requiredNumber && h1.workingEmployees.length == h2.workingEmployees.length);
			} else {
				assertTrue(h2.requiredNumber == 1 && h2.workingEmployees.length == 1);
			}
		}
	}
	
	/*
	 * workingEmployee == nemployee
	 */
	@Test
	void workingEmployeeEqualsNemployee() {
		temp.setRequiredNumber(2, 0, 8);
		temp.addWorkingPeriod(employee1, 0, 8);
		temp.addWorkingPeriod(employee2, 0, 8);
		for(int i = 0; i < 9; i++) {
			WorkSchedule.Hour h1 = temp.readSchedule(i);
			assertTrue(h1.requiredNumber == 2);
			assertTrue(h1.workingEmployees.length == 2);
		}
	}
	
	/*
	 * Start time and end time outside span of the workspace
	 */
	@Test
	void timeOutsideWorkSchedule() {
		assertDoesNotThrow(() -> {ws.setRequiredNumber(1, 25, Integer.MAX_VALUE);});
	}
	
	/*
	 * nEmployee == Integer.MAX_VALUE
	 */
	@Test
	void nEmployeeMax() {
		ws.setRequiredNumber(Integer.MAX_VALUE, 0, 5);
		for(int i = 0; i < 6; i++) {
			WorkSchedule.Hour h1 = ws.readSchedule(i);
			assertTrue(h1.requiredNumber == Integer.MAX_VALUE);
		}
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		ws = null;
		employee1 = null;
		employee2 = null;
	}
}
