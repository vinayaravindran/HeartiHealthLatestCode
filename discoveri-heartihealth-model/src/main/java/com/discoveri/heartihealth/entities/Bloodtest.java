package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;



/**
 * The persistent class for the bloodtest database table.
 * 
 */
@Entity
@Table(name="bloodtest")
public class Bloodtest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "blood_id")
	private int bloodId;

	private int bloodpressure;

	@Column(name = "memberinfo_member_id")
	private int memberInfoMemberId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int fbs;

	private int serumcholesterol;

	private int thal;

	public Bloodtest() {
	}

	public int getBloodId() {
		return this.bloodId;
	}

	public void setBloodId(int bloodId) {
		this.bloodId = bloodId;
	}

	public int getBloodpressure() {
		return this.bloodpressure;
	}

	public void setBloodpressure(int bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public int getCardiodiagnosisCardioId() {
		return this.memberInfoMemberId;
	}

	public void setCardiodiagnosisCardioId(int cardiodiagnosisCardioId) {
		this.memberInfoMemberId = cardiodiagnosisCardioId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFbs() {
		return this.fbs;
	}

	public void setFbs(int fbs) {
		this.fbs = fbs;
	}

	public int getSerumcholesterol() {
		return this.serumcholesterol;
	}

	public void setSerumcholesterol(int serumcholesterol) {
		this.serumcholesterol = serumcholesterol;
	}

	public int getThal() {
		return this.thal;
	}

	public void setThal(int thal) {
		this.thal = thal;
	}

}