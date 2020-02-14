package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the xray database table.
 * 
 */
@Entity
@Table(name="xray")
public class Xray implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Column(name="ca")
	private int ca;
	
	@ManyToOne
	@JoinColumn(name = "memberinfo_member_id")
	private int  memberInfoMemberId;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;

	@Id
	@Column(name="xray_id")
	private String xrayId;

	public Xray() {
	}

	public int getCa() {
		return ca;
	}

	public void setCa(int ca) {
		this.ca = ca;
	}

	

	public int getMemberInfoMemberId() {
		return memberInfoMemberId;
	}

	public void setMemberInfoMemberId(int memberInfoMemberId) {
		this.memberInfoMemberId = memberInfoMemberId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getXrayId() {
		return xrayId;
	}

	public void setXrayId(String xrayId) {
		this.xrayId = xrayId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

	
	
	

}