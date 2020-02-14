package com.discoveri.heartihealth.repositoryImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.discoveri.heartihealth.configuration.HibernateConfig;
import com.discoveri.heartihealth.dto.IntervalReportWeeklyDTO;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.SymptomPrediction;
import com.discoveri.heartihealth.dto.TotalPredictionDTO;
import com.discoveri.heartihealth.exceptions.HeartiException;
import com.discoveri.heartihealth.repository.HeartLiveInfoRepo;

@Repository
public class HeartLiveInfoRepoImpl implements HeartLiveInfoRepo {

	@Override
	public LivePrediction getLivePredictionByChestPain() throws HeartiException {

		LivePrediction livePrediction = new LivePrediction();
		List<SymptomPrediction> symptomPredictions = new ArrayList<SymptomPrediction>();

		Session sessionCon = null;
		Transaction transaction = null;
		int curDayPredictionValue = 0;

		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select s.date, s.cp from symptom s "
					+ "inner join cardiohistory c on s.memberinfo_member_id = c.memberinfo_member_id "
					+ "inner join memberinfo m on m.member_id = c.memberinfo_member_id "
					+ "where c.cardioarrestdetected = 1 and  DATE(s.date) = DATE(NOW())";

			List<Object[]> predictionObjects = sessionCon.createNativeQuery(sqlQuery).list();

			for (Object[] objects : predictionObjects) {
				SymptomPrediction prediction = new SymptomPrediction();

				prediction.setTimestamp(objects[0].toString());
				prediction.setSymptomValue(Integer.parseInt(objects[1].toString()));

				symptomPredictions.add(prediction);

			}

			curDayPredictionValue = getPredictionOfChestPainValueByDay(0);

			livePrediction.setSymptomType("Chest Pain");
			livePrediction.setSymptomPrediction(symptomPredictions);
			livePrediction.setTodayPredictionSymptomValue(curDayPredictionValue);
			livePrediction.setVariation(
					HeartiInfoRepoUtil.findVariation(curDayPredictionValue, getPredictionOfChestPainValueByDay(1)));
			livePrediction.setUp(livePrediction.getVariation() < 0 ? false : true);

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

		return livePrediction;

	}

	@Override
	public LivePrediction getLivePredictionByBloodPressure() throws HeartiException {
		LivePrediction livePrediction = new LivePrediction();
		List<SymptomPrediction> symptomPredictions = new ArrayList<SymptomPrediction>();

		Session sessionCon = null;
		Transaction transaction = null;
		int curDayPredictionValue = 0;

		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select  b.date, b.bloodpressure from bloodtest b inner join cardiohistory c "
					+ "on b.memberinfo_member_id = c.memberinfo_member_id inner join memberinfo m  "
					+ "on m.member_id = c.memberinfo_member_id "
					+ "where c.cardioarrestdetected = 1 and DATE(b.date) = DATE(NOW())";

			List<Object[]> predictionObjects = sessionCon.createNativeQuery(sqlQuery).list();

			for (Object[] objects : predictionObjects) {
				SymptomPrediction prediction = new SymptomPrediction();

				prediction.setTimestamp(objects[0].toString());
				prediction.setSymptomValue(Integer.parseInt(objects[1].toString()));

				symptomPredictions.add(prediction);

			}

			curDayPredictionValue = getPredictionOfBloodPressureValueByDay(0);

			livePrediction.setSymptomType("Blood Pressure");
			livePrediction.setSymptomPrediction(symptomPredictions);
			livePrediction.setTodayPredictionSymptomValue(curDayPredictionValue);
			livePrediction.setVariation(
					HeartiInfoRepoUtil.findVariation(curDayPredictionValue, getPredictionOfBloodPressureValueByDay(1)));
			livePrediction.setUp(livePrediction.getVariation() < 0 ? false : true);

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

		return livePrediction;
	}

	@Override
	public LivePrediction getLivePredictionByCholesterol() throws HeartiException {
		LivePrediction livePrediction = new LivePrediction();
		List<SymptomPrediction> symptomPredictions = new ArrayList<SymptomPrediction>();

		Session sessionCon = null;
		Transaction transaction = null;
		int curDayPredictionValue = 0;

		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select  b.date, b.serumcholesterol from bloodtest b inner join cardiohistory c "
					+ "on b.memberinfo_member_id = c.memberinfo_member_id inner join memberinfo m  "
					+ "on m.member_id = c.memberinfo_member_id "
					+ "where c.cardioarrestdetected = 1 and DATE(b.date) = DATE(NOW())";

			List<Object[]> predictionObjects = sessionCon.createNativeQuery(sqlQuery).list();

			for (Object[] objects : predictionObjects) {
				SymptomPrediction prediction = new SymptomPrediction();

				prediction.setTimestamp(objects[0].toString());
				prediction.setSymptomValue(Integer.parseInt(objects[1].toString()));

				symptomPredictions.add(prediction);

			}

			curDayPredictionValue = getPredictionOfCholesterolValueByDay(0);

			livePrediction.setSymptomType("Cholesterol");
			livePrediction.setSymptomPrediction(symptomPredictions);
			livePrediction.setTodayPredictionSymptomValue(curDayPredictionValue);
			livePrediction.setVariation(
					HeartiInfoRepoUtil.findVariation(curDayPredictionValue, getPredictionOfCholesterolValueByDay(1)));
			livePrediction.setUp(livePrediction.getVariation() < 0 ? false : true);

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

		return livePrediction;
	}

	@Override
	public int getPredictionOfChestPainValueByDay(int day) throws HeartiException {
		int dayPrediction = 0;
		Session sessionCon = null;
		Transaction transaction = null;
		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select sum(s.cp) from symptom s inner join cardiohistory c on s.memberinfo_member_id = c. memberinfo_member_id "
					+ "inner join memberinfo m on m.member_id = c.memberinfo_member_id "
					+ "where c.cardioarrestdetected = 1 and  DATE(s.date) = DATE(NOW() - interval " + day + " day)";

			NativeQuery query = sessionCon.createNativeQuery(sqlQuery);

			dayPrediction = ((Number) query.getSingleResult()).intValue();

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

		return dayPrediction;
	}

	@Override
	public int getPredictionOfBloodPressureValueByDay(int day) throws HeartiException {
		int dayPrediction = 0;
		Session sessionCon = null;
		Transaction transaction = null;
		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select sum(b.bloodpressure) from bloodtest b inner join cardiohistory c "
					+ " on b.memberinfo_member_id = c.memberinfo_member_id " + "	inner join memberinfo m  "
					+ "on m.member_id = c.memberinfo_member_id where c.cardioarrestdetected = 1 and  "
					+ "DATE(b.date) = DATE(NOW() - interval " + day + " day)";

			NativeQuery query = sessionCon.createNativeQuery(sqlQuery);

			dayPrediction = ((Number) query.getSingleResult()).intValue();

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

		return dayPrediction;
	}

	@Override
	public int getPredictionOfCholesterolValueByDay(int day) throws HeartiException {
		int dayPrediction = 0;
		Session sessionCon = null;
		Transaction transaction = null;
		try {
			sessionCon = HibernateConfig.buildSessionFactory().openSession();
			transaction = sessionCon.getTransaction();
			transaction.begin();

			String sqlQuery = "select sum(b.serumcholesterol) from bloodtest b inner join cardiohistory c "
					+ " on b.memberinfo_member_id = c.memberinfo_member_id " + "	inner join memberinfo m  "
					+ "on m.member_id = c.memberinfo_member_id where c.cardioarrestdetected = 1 and  "
					+ "DATE(b.date) = DATE(NOW() - interval " + day + " day)";

			NativeQuery query = sessionCon.createNativeQuery(sqlQuery);

			dayPrediction = ((Number) query.getSingleResult()).intValue();

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

		return dayPrediction;
	}

}
