package com.discoveri.heartihealth.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the addressinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Addressinfo.findAll", query="SELECT a FROM Addressinfo a")
public class Addressinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	private int addressId;

	private String city;

	private String country;

	@Column(name="memberinfo_member_id")
	private int memberinfoMemberId;

	private int pincode;

	private String state;

	public Addressinfo() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMemberinfoMemberId() {
		return this.memberinfoMemberId;
	}

	public void setMemberinfoMemberId(int memberinfoMemberId) {
		this.memberinfoMemberId = memberinfoMemberId;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}