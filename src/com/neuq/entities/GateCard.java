package com.neuq.entities;

public class GateCard {
	private int id;
	private User user;
	private String date;
	private int days;
	
	public GateCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GateCard(int id, User user, String date, int days) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.days = days;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "GateCard [id=" + id + ", user=" + user + ", date=" + date + ", days=" + days + "]";
	}
	
}
