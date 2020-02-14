package com.discoveri.heartihealth.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.HeartiInfoService;
import com.discoveri.heartihealth.dto.IntervalReportWeeklyDTO;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.TotalPredictionDTO;
import com.discoveri.heartihealth.exceptions.HeartiException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HeartiController {

	@Autowired
	private HeartiInfoService heartInfoService;

	@RequestMapping(value = "/api/livePredictions", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<List<LivePrediction>> getLivePrediction() throws SQLException {

		List<LivePrediction> livePredictions = null;
		ResponseEntity<List<LivePrediction>> liveDTO = null;
		HttpStatus httpStatus = null;
		try {
			livePredictions = heartInfoService.getLivePrediction();

			httpStatus = (livePredictions == null) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

			liveDTO = new ResponseEntity<List<LivePrediction>>(livePredictions, httpStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liveDTO;
	}

	@RequestMapping(value = "/api/getTotalPredictionByPeriod/{interval}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<List<TotalPredictionDTO>> getTotalPredictionByPeriod(@PathVariable String interval)
			throws SQLException {

		List<TotalPredictionDTO> listOfPredictions = null;
		ResponseEntity<List<TotalPredictionDTO>> reportDTO = null;
		HttpStatus httpStatus = null;

		try {

			listOfPredictions = heartInfoService.getTotalPredictionByPeriod(interval);

			httpStatus = (listOfPredictions == null) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

			reportDTO = new ResponseEntity<List<TotalPredictionDTO>>(listOfPredictions, httpStatus);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportDTO;
	}

	@RequestMapping(value = "/api/intervalReport/weeklyReport", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<IntervalReportWeeklyDTO>> intervalReport() throws SQLException {
		List<IntervalReportWeeklyDTO> listOfPredictions = null;
		ResponseEntity<List<IntervalReportWeeklyDTO>> reportDTO = null;
		HttpStatus httpStatus = null;
		try {

			listOfPredictions = heartInfoService.getWeeklyPredictionsReport();

			httpStatus = (listOfPredictions == null) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

			reportDTO = new ResponseEntity<List<IntervalReportWeeklyDTO>>(listOfPredictions, httpStatus);

		} catch (HeartiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reportDTO;
	}
}