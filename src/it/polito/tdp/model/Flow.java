package it.polito.tdp.model;

import java.time.LocalDate;

public class Flow {

	private int id;
	private LocalDate day;
	private double flow;
	private River river;

	public Flow(int id, LocalDate day, double flow, River river) {
		this.id = id;
		this.day = day;
		this.flow = flow;
		this.river = river;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public River getRiver() {
		return river;
	}

	public void setRiver(River river) {
		this.river = river;
	}

}
