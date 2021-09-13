package com.retail.store.api.model;

import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.retail.store.api.enums.UserEnums;

/* 
 * @author Tlotlo Lebotse
 * @version 1.0
 * @description User object class containing user attributes
 * 
 */
public class User {
	
	private String firstName;
	private String lastName;
	private String type;
	private Date joinDate;
	
	public User() {
	}

	public User(String firstName, String lastName, String type, Date joinDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.joinDate = joinDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", type=" + type + ", joinDate=" + joinDate
				+ "]";
	}
	
	public boolean isCustomerMoreThan2Years() {
		
		Calendar a = getCalendar(getJoinDate());
	    Calendar b = getCalendar(new Date());
	    int diff = b.get(YEAR) - a.get(YEAR);
	    
	    if(diff >= 2 ) {
	    	return true;
	    }
	    return false;
	}
	
	public Calendar getCalendar(Date date) {
	    Calendar calendar = Calendar.getInstance(Locale.US);
	    calendar.setTime(date);
	    return calendar;
	}
}
