package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CONTACT_DETAILS")
public class Contact {
	@Id
	//@Column(name = "CONTACT_ID")
	@GeneratedValue
	private Integer contactid;
	//@Column(name = "CONTACT_NAME")
	private String contactname;
	//@Column(name = "CONTACT_EMAIL")
	private String contactemail;
	//@Column(name = "CONTACT_NUMBER")
	private Integer contactnumber;
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
   public Integer getContactid() {
		return contactid;
	}
	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getContactemail() {
		return contactemail;
	}
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	public Integer getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(Integer contactnumber) {
		this.contactnumber = contactnumber;
	}
	
	@Override
	public String toString() {
		return "Contact [contactid=" + contactid + ", contactname=" + contactname + ", contactemail="
				+ contactemail + ", contactnumber=" + contactnumber + ", isActive=" + isActive + "]";
	}
	
	
	

}
