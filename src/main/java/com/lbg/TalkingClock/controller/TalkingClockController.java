package com.lbg.TalkingClock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.TalkingClock.services.TalkingClockService;

@RestController
public class TalkingClockController {

	@Autowired
	TalkingClockService clockService;

	@GetMapping("/talking-clock/{time}")

	public String getTime(@PathVariable String time) {
		String humanFriendlyTime = clockService.getTime(time);
		return humanFriendlyTime;

	}

}
