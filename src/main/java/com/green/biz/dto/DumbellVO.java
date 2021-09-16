package com.green.biz.dto;

public class DumbellVO {
	private int deseq;
	private String dex_name;
	private String dex_part;
	private String dex_description;
	private String dex_img;
	private boolean dex_ckbox;
	
	public int getDeseq() {
		return deseq;
	}
	public void setDeseq(int deseq) {
		this.deseq = deseq;
	}
	public String getDex_name() {
		return dex_name;
	}
	public void setDex_name(String dex_name) {
		this.dex_name = dex_name;
	}
	public String getDex_part() {
		return dex_part;
	}
	public void setDex_part(String dex_part) {
		this.dex_part = dex_part;
	}
	public String getDex_description() {
		return dex_description;
	}
	public void setDex_description(String dex_description) {
		this.dex_description = dex_description;
	}
	public String getDex_img() {
		return dex_img;
	}
	public void setDex_img(String dex_img) {
		this.dex_img = dex_img;
	}
	public boolean isDex_ckbox() {
		return dex_ckbox;
	}
	public void setDex_ckbox(boolean dex_ckbox) {
		this.dex_ckbox = dex_ckbox;
	}
	@Override
	public String toString() {
		return "DumbellVO [deseq=" + deseq + ", dex_name=" + dex_name + ", dex_part=" + dex_part + ", dex_description="
				+ dex_description + ", dex_img=" + dex_img + ", dex_ckbox=" + dex_ckbox + "]";
	}
	
}
