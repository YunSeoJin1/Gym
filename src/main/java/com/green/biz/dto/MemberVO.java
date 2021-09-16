package com.green.biz.dto;

import java.sql.*;

public class MemberVO {
	private String name;
	private String id;
	private String pwd;
	private String pwdcheck;
	private String email;
	private String phone;
	private String profile_img;
	private float height;
	private float weight;
	private Timestamp regdate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdcheck() {
		return pwdcheck;
	}
	public void setPwdcheck(String pwdcheck) {
		this.pwdcheck = pwdcheck;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + ", pwd=" + pwd + ", pwdcheck=" + pwdcheck + ", email=" + email
				+ ", phone=" + phone + ", profile_img=" + profile_img + ", height=" + height + ", weight=" + weight
				+ ", regdate=" + regdate + "]";
	}
	
	
}
	