package com.lbg.TalkingClock.standaloneUtil;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class TalkingClock {
	

	private static final Map<Integer, String> HOURS = new HashMap<>();
	private static final Map<Integer, String> MINUTES = new HashMap<>();

	static {
		HOURS.put(1, "One");
		HOURS.put(2, "Two");
		HOURS.put(3, "Three");
		HOURS.put(4, "Four");
		HOURS.put(5, "Five");
		HOURS.put(6, "Six");
		HOURS.put(7, "Seven");
		HOURS.put(8, "Eight");
		HOURS.put(9, "Nine");
		HOURS.put(10, "Ten");
		HOURS.put(11, "Eleven");
		HOURS.put(12, "Twelve");

		MINUTES.put(0, "o'clock");
		MINUTES.put(5, "five past");
		MINUTES.put(10, "ten past");
		MINUTES.put(15, "quarter past");
		MINUTES.put(20, "twenty past");
		MINUTES.put(25, "twenty five past");
		MINUTES.put(30, "half past");
		MINUTES.put(35, "twenty five to");
		MINUTES.put(40, "twenty to");
		MINUTES.put(45, "quarter to");
		MINUTES.put(50, "ten to");
		MINUTES.put(55, "five to");
	}

	public static void main(String[] args) {
		// Task 1: Returns current time in human-friendly text
		showCurrentTimeInHumanFriendlyText();

		// Task 2: Allow the command to take an arbitrary Numeric Time parameter as
		// input and return the "Human Friendly Text" equivalent.
		convertArbitraryTimeToFriendlyText();

	}

	private static void showCurrentTimeInHumanFriendlyText() {
		// TODO Auto-generated method stub
		LocalTime currentTime = LocalTime.now();
		int hour = currentTime.getHour();
		int minute = currentTime.getMinute();
		String timeInText = convertToFriendlyText(hour, minute);
		System.out.println(timeInText);
	}

	/**
	 * Method with logic to covert time into friendly text
	 * 
	 * @param hour
	 * @param minute
	 * @return
	 */
	private static String convertToFriendlyText(int hour, int minute) {
		String hourText = HOURS.get(hour % 12);
		String minuteText = MINUTES.get(minute / 5 * 5);
		String timeInText;
		if (minuteText.contains("past")) {
			minuteText = MINUTES.get(minute / 5 * 5);
			timeInText = minuteText + " " + hourText;
		} else if (minute >= 35) {
			hourText = HOURS.get((hour + 1) % 12);
			timeInText = minuteText + " " + hourText;
		} else {
			timeInText = hourText + " " + minuteText;
		}

		return timeInText;
	}

	/**
	 * Method to take Arbitrary time from user and covert into friendly text
	 */
	private static void convertArbitraryTimeToFriendlyText() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n*******************************************************************************");
		System.out.println("*** Hey, I am talking time, do you want to test me ?  *** ");
		System.out.print("Enter a numeric time (hh:mm): ");
		String numericTime = scanner.nextLine();

		String[] parts = numericTime.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		String timeInText = convertToFriendlyText(hour, minute);
		System.out.println(timeInText);
		System.out.println("\n*******************************************************************************");
		scanner.close();
	}

	public String getTime(String time) {
		// TODO Auto-generated method stub

		// validate the input time 1st
		Validator.validate(time);

		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		String timeInText = convertToFriendlyText(hour, minute);
		return timeInText;
	}

	

}
