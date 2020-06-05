package com.example.demo.model;

import java.util.Calendar;

public class Search {
	private String place;
	private Calendar dateFrom;
	private Calendar dateTo;

	public Search(String place, Calendar dateFrom, Calendar dateTo) {
		super();
		this.place = place;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Calendar getDateTo() {
		return dateTo;
	}

	public void setDateTo(Calendar dateTo) {
		this.dateTo = dateTo;
	}

}
