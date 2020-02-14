
package com.discoveri.heartihealth.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
 
@Entity
@Table(name = "memberinfo")
public class Memberinfo implements Serializable {
    private static final long serialVersionUID = 1L;


    private int age;


    private String email;

    private String firstname;

    private String gender;

    private String lastname;

    @Id
    @Column(name="member_id")
    private String memberId;

    private BigInteger phonenumber;

    private String username;


    public Memberinfo() {
    }


    public int getAge() {
        return this.age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstname() {
        return this.firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getGender() {
        return this.gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getLastname() {
        return this.lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }




    public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public BigInteger getPhonenumber() {
        return this.phonenumber;
    }


    public void setPhonenumber(BigInteger phonenumber) {
        this.phonenumber = phonenumber;
    }


    public String getUsername() {
        return this.username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


}































