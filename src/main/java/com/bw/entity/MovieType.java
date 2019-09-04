package com.bw.entity;

public class MovieType {

	private Integer mid;
	private Integer tid;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public MovieType(Integer mid, Integer tid) {
		super();
		this.mid = mid;
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "MovirType [mid=" + mid + ", tid=" + tid + "]";
	}
	public MovieType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
