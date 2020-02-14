package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.dto.IntervalReportWeeklyDTO;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.TotalPredictionDTO;
import com.discoveri.heartihealth.exceptions.HeartiException;

public interface HeartiInfoService {

	List<TotalPredictionDTO> getTotalPredictionByPeriod(String interval) throws HeartiException;

	List<IntervalReportWeeklyDTO> getWeeklyPredictionsReport() throws HeartiException;
	
	List<LivePrediction> getLivePrediction() throws HeartiException;

}
