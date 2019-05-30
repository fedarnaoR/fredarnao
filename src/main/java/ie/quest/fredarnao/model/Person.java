package ie.quest.fredarnao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {	
	public Person(String ppsNumber, String name, Date dob, String mobilePhone, Date creationDate) {
		super();
		
		this.ppsNumber = ppsNumber.toUpperCase();
		this.name = name;
		this.dob = dob;
		this.mobilePhone = mobilePhone;
		this.creationDate = creationDate != null ? creationDate : new Date();
	}
	
	public Person(String ppsNumber, String name, Date dob, String mobilePhone) {
		this(ppsNumber, name, dob, mobilePhone, null);
	}
		
	public Person(String ppsNumber, String name, Date dob) {
		this(ppsNumber, name, dob, null);
	}
	
	public Person() {
		super();
	}

	//PPSN is always saved in upper case.
	public String getPpsNumber() {
		return ppsNumber.toUpperCase();
	}
	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber.toUpperCase();
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
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = (creationDate != null) ? creationDate : new Date();
	}
	
	@Id
	private String ppsNumber;
	private String name;
	private Date dob;
	private String mobilePhone;
	
	//This one is used to order the people list. It is a hidden field (only in the database)
	private Date creationDate;
}
