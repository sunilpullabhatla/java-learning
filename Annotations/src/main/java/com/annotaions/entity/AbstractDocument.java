package com.annotaions.entity;

import java.util.Date;

import com.annotations.customAnnotations.Regx;

public class AbstractDocument implements Document {

	@Regx(expression="^[a-zA-z ]*$")
	public String fullname;
	@Regx(expression="^[a-zA-z ]*$")
	public String fatherName;
	
	@Regx(expression="^male$|^female$")
	public String gender;
	
	public Date dob;
	
	public String address;
	
	public String mobileNumber;
	
	public String email;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractDocument [fullname=" + fullname + ", fatherName=" + fatherName + ", gender=" + gender + ", dob="
				+ dob + ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
}
