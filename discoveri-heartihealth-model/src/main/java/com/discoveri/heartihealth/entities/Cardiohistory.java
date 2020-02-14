package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cardiohistory database table.
 * 
 */
@Entity
@Table(name="cardiohistory")
public class Cardiohistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="memberinfo_member_id")
	private int memberInfoMemberId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="diagnoseddate")
	private Date diagnosedDate;

	@Id
	@Column(name="disease_id")
	private int diseaseId;

	@Column(name="isrecovered")
	private boolean isRecovered;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="recovereddate")
	private Date recoveredDate;
	
	@Column(name="cardioarrestdetected")
	private boolean cardioArrestDetected;

	public Cardiohistory() {
	}

	public int getMemberInfoMemberId() {
		return memberInfoMemberId;
	}

	public void setMemberInfoMemberId(int memberInfoMemberId) {
		this.memberInfoMemberId = memberInfoMemberId;
	}

	public Date getDiagnosedDate() {
		return diagnosedDate;
	}

	public void setDiagnosedDate(Date diagnosedDate) {
		this.diagnosedDate = diagnosedDate;
	}

	public int getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}

	public boolean isRecovered() {
		return isRecovered;
	}

	public void setRecovered(boolean isRecovered) {
		this.isRecovered = isRecovered;
	}

	public Date getRecoveredDate() {
		return recoveredDate;
	}

	public void setRecoveredDate(Date recoveredDate) {
		this.recoveredDate = recoveredDate;
	}

	public boolean isCardioArrestDetected() {
		return cardioArrestDetected;
	}

	public void setCardioArrestDetected(boolean cardioArrestDetected) {
		this.cardioArrestDetected = cardioArrestDetected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}