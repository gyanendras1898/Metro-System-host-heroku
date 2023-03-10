package com.gyan.model.service;

import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyan.beans.Journey;
import com.gyan.model.persistence.JourneyDao;

@Service
public class JourneyServiceImpl implements JourneyService {
	@Autowired
	private JourneyDao journeyDao;
	@Autowired
	private CardService cardService;

	@Override
	public boolean swipeIn(int cardId, int stationId) {
		Journey journey = new Journey();
		journey.setCardId(cardId);
		journey.setBoardingStationNo(stationId);
		Timestamp swipeInTime = new Timestamp(System.currentTimeMillis());
		journey.setSwipeIn(swipeInTime);
		return journeyDao.save(journey) != null;
	}

	@Override
	public boolean swipeOut(int cardId, int stationId) {
		int currSourceStation = getSourceStation(cardId);
		double fare = (Math.abs(currSourceStation - stationId)) * 5;
		cardService.addCardBalance(cardId, -fare);
		Timestamp swipeOutTime = new Timestamp(System.currentTimeMillis());
		int affectedRows = 0;
//		int affectedRows = journeyDao.swipeOut(cardId, stationId, swipeOutTime, fare);
		return affectedRows>0;
	}

	@Override
	public int getSourceStation(int cardId) {
//		return journeyDao.getSourceStation(cardId);
		return 0;
	}

	@Override
	public double getFare(int cardId) {
		return 0;
//		journeyDao.getFare(cardId);
	}

	@Override
	public boolean isJourneyOngoing(int cardId) {
		return true;
//		journeyDao.isJourneyOngoing(cardId);
	}

	@Override
	public boolean getDuration(int cardId) {
		int lateTime = 20;
		int durationTime =0;
				//journeyDao.getDuration(cardId);
		return durationTime > lateTime;
	}

}
