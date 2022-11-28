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
			assertTrue(h.requiredNumber == h2.requiredNumber && h.workingEmployees == h2.workingEmployees);
		}
	}
	/*
	 * starttime > endtime
	 * workingEmployee <= nemployee
	 */
	@Test
	void workingEmployeeLesserThanNemployee() {
		temp.setRequiredNumber(3, 8, 1);
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h = ws.readSchedule(i);
			System.out.println(h.requiredNumber);
			System.out.println(Arrays.toString(h.workingEmployees));
			WorkSchedule.Hour h2 = temp.readSchedule(i);
			System.out.println(h2.requiredNumber);
			System.out.println(Arrays.toString(h2.workingEmployees));
			assertTrue(h.requiredNumber == h2.requiredNumber && h.workingEmployees == h2.workingEmployees);
		}
	}
	
	@Test
	/*
	 * workingEmployee.length > nemployee
	 *  endtime >= starttime
	 */
	void endGreaterWorkEmployeeGreater(){
		temp.setRequiredNumber(1, 1, 8);
		for(int i = 1; i < 9; i++) {
			WorkSchedule.Hour h = temp.readSchedule(i);
			assertTrue(h.requiredNumber == 1 && h.workingEmployees.length == 1);
		}
		
	}
	/*
	 * endtime >= starttime
	 * workingemployee <= nemployee
	 */
	@Test
	void endGreaterNemployeeGreater() {
		temp.setRequiredNumber(3, 3, 8);
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h = temp.readSchedule(i);
			WorkSchedule.Hour h2 = ws.readSchedule(i);
			if(i < 3 || i > 8) {
				assertTrue(h.requiredNumber == 3 || h.workingEmployees.length == 2);
			} else {
				assertTrue(h.requiredNumber == h2.requiredNumber && h.workingEmployees.length == h2.workingEmployees.length);
			}
		}
	}
	
	/*
	 * endtime == starttime
	 * 
	 */
	@Test
	void endtimeEqualToStartime() {
		temp.setRequiredNumber(1, 3, 3);
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
		for(int i = 0; i < 24; i++) {
			WorkSchedule.Hour h1 = temp.readSchedule(i);
			assertTrue(h1.requiredNumber == 2 && h1.workingEmployees.length == 2);
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		ws = null;
		employee1 = null;
		employee2 = null;
	}
}
