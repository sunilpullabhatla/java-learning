/**
 * 
 */
package com.annotaions.entity;

import java.util.Date;

import com.annotations.customAnnotations.NotNull;
import com.annotations.customAnnotations.Regx;

/**
 * Aadhar Document
 * 
 * @author Sunil Pavan
 *
 */
public class Aadhar extends AbstractDocument {

	@Regx(expression="^[2-9]{1}[0-9]{11}$" , PreValidators= {NotNull.class})
	public String aadharNo;


	public String getAadharNo() {
		return aadharNo;
	}



	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	
	@Override
	public String toString() {
		return "AbstractDocument [fullname=" + fullname + ", fatherName=" + fatherName + ", gender=" + gender + ", dob="
				+ dob + ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "aadharNo=" + aadharNo + "]";
	}

	
}
