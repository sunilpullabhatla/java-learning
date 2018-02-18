/**
 * 
 */
package com.annotaions.entity;

import java.util.Date;

import com.annotations.customAnnotations.Regx;

/**
 *  Pancard Document
 * 
 * @author Sunil Pavan
 *
 */
public class PanCard extends AbstractDocument {
	
	@Regx(expression="[A-Z]{5}\\\\d{4}[A-Z]{1}")
	public String panNumber;
	
	public String issuedBy;

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	
	@Override
	public String toString() {
		return "AbstractDocument [fullname=" + fullname + ", fatherName=" + fatherName + ", gender=" + gender + ", dob="
				+ dob + ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "panNumber=" + panNumber + ", issuedBy=" + issuedBy + "]";
	}
	
	
	

}
