package com.bw.entity;

public class Movie {

	private Integer mid;
	private String mname;
	private String introduction;
	private String author;
	private String mdate;
	
	private Integer tid;
	private String tname;
	private String tids;
	
	public String getTids() {
		return tids;
	}
	public void setTids(String tids) {
		this.tids = tids;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	public Movie(Integer mid, String mname, String introduction, String author, String mdate, Integer tid,
			String tname) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.introduction = introduction;
		this.author = author;
		this.mdate = mdate;
		this.tid = tid;
		this.tname = tname;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", introduction=" + introduction + ", author=" + author
				+ ", mdate=" + mdate + ", tid=" + tid + ", tname=" + tname + ", tids=" + tids + "]";
	}
	
	
	
	
}
