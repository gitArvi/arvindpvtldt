package Employeeportal.arvindpvtltd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private long empid;
	private String firstname;
	private String lastname;
	private String emailid;
	
     public Employee(long empid, String firstname, String lastname, String emailid) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
	}
     
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + "]";
	}
	
	
}
