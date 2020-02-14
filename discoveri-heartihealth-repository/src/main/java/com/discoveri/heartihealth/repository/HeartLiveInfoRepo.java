package com.discoveri.heartihealth.repository;

import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiException;

public interface HeartLiveInfoRepo {
	
	LivePrediction getLivePredictionByChestPain()  throws HeartiException;
	
	LivePrediction getLivePredictionByBloodPressure()  throws HeartiException;
	
	LivePrediction getLivePredictionByCholesterol()  throws HeartiException;
	
	int getPredictionOfChestPainValueByDay(int day) throws HeartiException;
	
	int getPredictionOfBloodPressureValueByDay(int day) throws HeartiException;
	
	int getPredictionOfCholesterolValueByDay(int day) throws HeartiException;

}
