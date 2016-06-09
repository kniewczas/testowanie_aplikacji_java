package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Processor {
	
	private long id;
	private String model;
	private String family;	
	private double clockRating;
	private int cores;
	
	public Processor(long id, String model, String family, double clockRating, int cores) {
		super();
		this.id = id;
		this.model = model;
		this.family = family;
		this.clockRating = clockRating;
		this.cores = cores;
	}
	
	public Processor() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public double getClockRating() {
		return clockRating;
	}
	public void setClockRating(double clockRating) {
		this.clockRating = clockRating;
	}
	public int getCores() {
		return cores;
	}
	public void setCores(int cores) {
		this.cores = cores;
	}
}
