package com.green.biz.dto;

import java.sql.Date;




public class MypageVO {
	
	private int useq;
	private String id;
	private float weight;
	
	private Date indate;
	
	public int getUseq() {
		return useq;
	}
	public void setUseq(int useq) {
		this.useq = useq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
		return "MypageVO [useq=" + useq + ", id=" + id + ", weight=" + weight + ", indate=" + indate + "]";
	}
	
	
}
