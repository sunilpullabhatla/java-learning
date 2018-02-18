/**
 * 
 */
package com.annotaions.entity;

import java.util.List;

/**
 * Bank Document
 * 
 * @author Sunil Pavan
 *
 */
public class BankStatement extends AbstractDocument{
	
	public String accountNumber;
	
	public List<Transaction> transactions;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AbstractDocument [fullname=" + fullname + ", fatherName=" + fatherName + ", gender=" + gender + ", dob="
				+ dob + ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "accountNumber=" + accountNumber + ", transactions=" + transactions + "]";
	}
	
	
	

}
