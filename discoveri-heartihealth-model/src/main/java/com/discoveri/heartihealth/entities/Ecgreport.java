package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ecgreport database table.
 * 
 */
@Entity
@Table(name="ecgreport")
public class Ecgreport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="memberinfo_member_id")
	private int memberInfoMemberId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Id
	@Column(name="ecg_id")
	private int ecgId;

	private int restecg;

	public Ecgreport() {
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

	public int getEcgId() {
		return this.ecgId;
	}

	public void setEcgId(int ecgId) {
		this.ecgId = ecgId;
	}

	public int getRestecg() {
		return this.restecg;
	}

	public void setRestecg(int restecg) {
		this.restecg = restecg;
	}

}