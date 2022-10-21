package com.app.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "card")
public class CardDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long citizenId;
	private String name;
	private Date dob;
	private String address; 
	private String email;
	private long mobile;
	private String gender;
	 @Column(columnDefinition = "varchar(255) default 'Pending'")
	private String state;
	@Column(nullable = true)
	private Date issueDate;
	@Column(nullable = true)
	private long aadharNo;
	
	public long getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(long citizenId) {
		this.citizenId = citizenId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public long getaadharNo() {
		return aadharNo;
	}
	public void setaadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	public CardDetails(long citizenId, String name, Date dob, String address, String email, long mobile, String gender, String state, Date issueDate, long aadharNo) {
		super();
		this.citizenId = citizenId;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.state = state;
		this.issueDate = issueDate;
		this.aadharNo = aadharNo;
	}
	
	public CardDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "CardDetails [citizenId=" + citizenId + ", name=" + name + ", dob=" + dob + ", address=" + address
				+ ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", state=" + state + ", issueDate="
				+ issueDate + ", aadharNo=" + aadharNo + "]";
	}
	
}