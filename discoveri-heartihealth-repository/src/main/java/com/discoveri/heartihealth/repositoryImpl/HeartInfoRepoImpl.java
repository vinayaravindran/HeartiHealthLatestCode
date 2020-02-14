package com.discoveri.heartihealth.repositoryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.discoveri.heartihealth.configuration.HibernateConfig;
import com.discoveri.heartihealth.dto.IntervalReportWeeklyDTO;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.TotalPredictionDTO;
import com.discoveri.heartihealth.exceptions.HeartiException;
import com.discoveri.heartihealth.repository.HeartInfoRepo;
import com.discoveri.heartihealth.repository.HeartLiveInfoRepo;

@Repository
public class HeartInfoRepoImpl implements HeartInfoRepo {

	@Autowired
	public HeartLiveInfoRepo heartLiveInfoRepo;

	@Override
	public List<IntervalReportWeeklyDTO> getWeeklyPredictionsReport() throws HeartiException {

		List<IntervalReportWeeklyDTO> weeklyPredictions = new ArrayList<IntervalReportWeeklyDTO>();

		Session sessionCon = null;
		Transaction transaction = null;
		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select DAYNAME(c.diagnoseddate) ,SUM(c.cardioarrestdetected), SUM(c.isrecovered) "
					+ "from Memberinfo m inner join CardioHistory c on m.member_id = c.memberinfo_member_id "
					+ "WHERE c.diagnoseddate > DATE_SUB(NOW(), INTERVAL 1 WEEK) and c.diagnoseddate <= Date(NOW()) GROUP BY Date(c.diagnoseddate)";

			List<Object[]> predictionObjects = sessionCon.createNativeQuery(sqlQuery).list();

			for (Object[] objects : predictionObjects) {
				IntervalReportWeeklyDTO prediction = new IntervalReportWeeklyDTO();
				prediction.setInterval(objects[0].toString());
				prediction.setCured(Integer.parseInt(objects[1].toString()));
				prediction.setPredicted(Integer.parseInt(objects[2].toString()));

				weeklyPredictions.add(prediction);

			}

		}

		catch (Exception e) {
			if (null != sessionCon.getTransaction()) {
				sessionCon.getTransaction().rollback();
			}

			throw new HeartiException(e.getMessage());
		} finally {
			if (sessionCon != null) {
				sessionCon.close();
			}
		}

		return weeklyPredictions;
	}

	@Override
	public List<TotalPredictionDTO> getTotalPredictionByPeriod(String interval) throws HeartiException {
		List<TotalPredictionDTO> predictions = new ArrayList<TotalPredictionDTO>();

		Session sessionCon = null;
		Transaction transaction = null;
		int prevPrediction = 0;
		boolean ignoreFirst = true;
		String sqlQuery = "";
		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			if (interval.equalsIgnoreCase("weekly")) {
				sqlQuery = "SELECT DAYNAME(c.diagnoseddate),sum(c.cardioarrestdetected) from memberinfo m inner join cardiohistory c on m.member_id = c.memberinfo_member_id "
						+ "WHERE c.diagnoseddate >   DATE_SUB(NOW(), INTERVAL 8 day) and c.diagnoseddate <= Date(NOW()) group by Date(c.diagnoseddate) "
						+ "order by Date(c.diagnoseddate) asc ;";
			} else if (interval.equalsIgnoreCase("monthly")) {

				sqlQuery = "SELECT  MONTHNAME(STR_TO_DATE(month(c.diagnoseddate), '%m')),sum(c.cardioarrestdetected) from memberinfo m inner join cardiohistory c on m.member_id = c.memberinfo_member_id "
						+ "WHERE c.diagnoseddate >   DATE_SUB(NOW(), INTERVAL 365 day) and c.diagnoseddate <= NOW()"
						+ "group by month(c.diagnoseddate),year(c.diagnoseddate) order by c.diagnoseddate asc;";
			} else if (interval.equalsIgnoreCase("yearly")) {

				sqlQuery = "select year(c.diagnoseddate),sum(c.cardioarrestdetected) from memberinfo m  inner join cardiohistory  c on "
						+ "c.memberinfo_member_id = m.member_id  group by year(c.diagnoseddate) order by year(c.diagnoseddate) asc;";
			}

			List<Object[]> predictionObjects = sessionCon.createNativeQuery(sqlQuery).list();

			for (Object[] objects : predictionObjects) {
				TotalPredictionDTO prediction = new TotalPredictionDTO();

				prediction.setInterval(objects[0].toString());
				prediction.setTotalPrediction(Integer.parseInt(objects[1].toString()));
				prediction.setVariation(ignoreFirst ? 0
						: HeartiInfoRepoUtil.findVariation(prediction.getTotalPrediction(), prevPrediction));
				ignoreFirst = false;
				prediction.setUp(prediction.getVariation() < 0 ? false : true);

				prevPrediction = prediction.getTotalPrediction();

				predictions.add(prediction);

			}

		}

		catch (Exception e) {
			if (null != sessionCon.getTransaction()) {
				sessionCon.getTransaction().rollback();
			}

			throw new HeartiException(e.getMessage());
		} finally {
			if (sessionCon != null) {
				sessionCon.close();
			}
		}

		// Collections.reverse(predictions);

		return predictions;
	}

	@Override
	public List<LivePrediction> getLivePrediction() throws HeartiException {
		List<LivePrediction> livePredictions = new ArrayList<LivePrediction>();

		livePredictions.add(heartLiveInfoRepo.getLivePredictionByChestPain());
		livePredictions.add(heartLiveInfoRepo.getLivePredictionByBloodPressure());
		livePredictions.add(heartLiveInfoRepo.getLivePredictionByCholesterol());

		return livePredictions;
	}

}
