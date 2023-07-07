package com.lbg.TalkingClock.standaloneUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TalkingClockTest  {
	
	TalkingClock unit;

	@BeforeEach
	void setUp() throws Exception {
		unit=new TalkingClock();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test_empty_time_should_throw_exception() {
		String inputTime="";
		assertThrows(InvalidInputException.class, () -> unit.getTime(inputTime)) ;
		String errorMessage = assertThrows(InvalidInputException.class,
				() ->  unit.getTime(inputTime)).getMessage();
		assertEquals(errorMessage, Validator.EMPTY_TIME_ERROR );
		
	}
	
	@Test
	void test_invalid_time_with_only_hours_without_minute_should_throw_exception() {
		String inputTime="13";
		String errorMessage = assertThrows(InvalidInputException.class,
				() ->  unit.getTime(inputTime)).getMessage();
		assertEquals(errorMessage, Validator.INVALID_TIME_FORMAT_ERROR );
		
	}
	
	@Test
	void test_invalid_range_time_should_throw_exception() {
		String inputTime="34:90";
		String errorMessage = assertThrows(InvalidInputException.class,
				() ->  unit.getTime(inputTime)).getMessage();
		assertEquals(errorMessage, Validator.INVALID_TIME_FORMAT_ERROR );
		
	}

	@Test
	void test_hours_with_zero_minute_should_return_valid_text() {
		String inputTime="13:00";
		String result= unit.getTime(inputTime);
		assertEquals("One o'clock",result);
		
	}
	
	@Test
	void test_hours_with_min_past_should_return_valid_text() {
		String inputTime="13:05";
		String result= unit.getTime(inputTime);
		assertEquals("five past One",result);
		
		inputTime="13:15";
		result= unit.getTime(inputTime);
		assertEquals("quarter past One",result);
		
		
		inputTime="13:30";
		result= unit.getTime(inputTime);
		assertEquals("half past One",result);
		
	}
	
	@Test
	void test_hours_with_min_to_should_return_valid_text() {
		String inputTime="13:55";
		String result= unit.getTime(inputTime);
		assertEquals("five to Two",result);
		
		inputTime="13:35";
		result= unit.getTime(inputTime);
		assertEquals("twenty five to Two",result);
		
		
		inputTime="13:45";
		result= unit.getTime(inputTime);
		assertEquals("quarter to Two",result);
		
		
	}

}
