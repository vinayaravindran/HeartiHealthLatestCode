package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wearabledevicedata database table.
 * 
 */
@Entity
@Table(name="wearabledevicedata")
public class Wearabledevicedata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="memberinfo_member_id")
	private int memberInfoMemberId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int slope;

	private int thalach;

	@Id
	@Column(name="wearable_device_id")
	private int wearableDeviceId;

	public Wearabledevicedata() {
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

	public int getSlope() {
		return this.slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}

	public int getThalach() {
		return this.thalach;
	}

	public void setThalach(int thalach) {
		this.thalach = thalach;
	}

	public int getWearableDeviceId() {
		return this.wearableDeviceId;
	}

	public void setWearableDeviceId(int wearableDeviceId) {
		this.wearableDeviceId = wearableDeviceId;
	}

}