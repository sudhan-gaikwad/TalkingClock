package com.lbg.TalkingClock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbg.TalkingClock.standaloneUtil.TalkingClock;

@Service
public class TalkingClockService {
	
	@Autowired
	TalkingClock clock;
	
	public String getTime(String time) {
		String humanFriendlyTime = clock.getTime(time);
		return humanFriendlyTime;

	}

}
