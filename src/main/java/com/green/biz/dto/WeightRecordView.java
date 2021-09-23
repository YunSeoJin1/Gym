package com.green.biz.dto;

import java.sql.Date;

public class WeightRecordView {
	private float weight;
	private Date indate;
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "WeightRecord [weight=" + weight + ", indate=" + indate + "]";
	}
	
	
}
