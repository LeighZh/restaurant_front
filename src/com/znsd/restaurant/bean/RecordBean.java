package com.znsd.restaurant.bean;

//消费记录
public class RecordBean {
	private int recordId;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	private String userName;//用户名称
	//private Date consumptionTime;//消费时间
	private double consumptionMoney;//消费金额
	private String time;//消费时间
	public String getTime() {
		return time;
	}
	public RecordBean(int recordId, String userName, double consumptionMoney, String time) {
		super();
		this.recordId = recordId;
		this.userName = userName;
		this.consumptionMoney = consumptionMoney;
		this.time = time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public RecordBean(String userName, double consumptionMoney, String time) {
		super();
		this.userName = userName;
		this.consumptionMoney = consumptionMoney;
		this.time = time;
	}
	public RecordBean() {
		super();
	}
	/*public RecordBean( String userName,Date consumptionTime,double consumptionMoney) {
		super();
		this.userName = userName;
		this.consumptionTime = consumptionTime;
		this.consumptionMoney = consumptionMoney;
	}*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*public Date getConsumptionTime() {
		return consumptionTime;
	}
	public void setConsumptionTime(Date consumptionTime) {
		this.consumptionTime = consumptionTime;
	}*/
	public double getConsumptionMoney() {
		return consumptionMoney;
	}
	public void setConsumptionMoney(double consumptionMoney) {
		this.consumptionMoney = consumptionMoney;
	}
	@Override
	public String toString() {
		return "Record [userName=" + userName + ", time=" + time
				+ ", consumptionMoney=" + consumptionMoney + "]";
	}
}
