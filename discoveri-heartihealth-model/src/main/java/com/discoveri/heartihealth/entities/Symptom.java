package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the symptom database table.
 * 
 */
@Entity
@Table(name="symptom")
public class Symptom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="memberinfo_member_id")
	private int memberInfoMemberId;

	private int cp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int exang;

	private float oldpeak;

	@Id
	@Column(name="symptom_id")
	private int symptomId;

	public Symptom() {
	}

	public int getCardiodiagnosisCardioId() {
		return this.memberInfoMemberId;
	}

	public void setCardiodiagnosisCardioId(int cardiodiagnosisCardioId) {
		this.memberInfoMemberId = cardiodiagnosisCardioId;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getExang() {
		return this.exang;
	}

	public void setExang(int exang) {
		this.exang = exang;
	}

	public float getOldpeak() {
		return this.oldpeak;
	}

	public void setOldpeak(float oldpeak) {
		this.oldpeak = oldpeak;
	}

	public int getSymptomId() {
		return this.symptomId;
	}

	public void setSymptomId(int symptomId) {
		this.symptomId = symptomId;
	}

}