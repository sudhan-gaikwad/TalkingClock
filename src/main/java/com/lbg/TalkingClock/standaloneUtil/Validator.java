package com.lbg.TalkingClock.standaloneUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validator {
	
	String NULL_TIME_ERROR= "Time Can not be null";
	String EMPTY_TIME_ERROR= "Time Can not be empty";
	String INVALID_TIME_FORMAT_ERROR= "Please specify time in valid hh:mm format";
	
	
	public static void validate(String time) {
		// TODO Auto-generated method stub
		if (null == time) {
			throw new InvalidInputException(NULL_TIME_ERROR);
		} else if (time.trim().equals("")) {
			throw new InvalidInputException(EMPTY_TIME_ERROR);
		} else if (!time.contains(":")) {
			throw new InvalidInputException(INVALID_TIME_FORMAT_ERROR);
		} else {
			// Regex to check valid Time
			String regex = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";

			// Compile the ReGex
			Pattern p = Pattern.compile(regex);

			Matcher m = p.matcher(time);

			// matched the ReGex
			if (!m.matches()) {
				throw new InvalidInputException(INVALID_TIME_FORMAT_ERROR);
			}
		}

	}
	
}
