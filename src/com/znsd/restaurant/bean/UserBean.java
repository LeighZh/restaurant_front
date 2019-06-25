package com.znsd.restaurant.bean;

//用户
public class UserBean {
	private int userId;//用户id
	private String userName;//用户名
	private String password;//密码
	private String createTime;//创建时间
	private String lastTime;//最后一次登录时间
	private long number;//预留号码
	private double money;//消费总金额
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public UserBean( String userName, String createTime, String lastTime, long number,double money) {
		super();
		this.userName = userName;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.number = number;
		this.money = money;
	}
	public UserBean( String userName, String createTime, String lastTime, long number,double money, String status) {
		super();
		this.userName = userName;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.number = number;
		this.money = money;
		this.status = status;
	}
	public UserBean(String userName, String password, long number) {
		super();
		this.userName = userName;
		this.password = password;
		this.number = number;
	}
	public UserBean() {
		super();
	}
	public UserBean(int userId, String userName, String password, String createTime, String lastTime, long number) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.number = number;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", createTime="
				+ createTime + ", lastTime=" + lastTime + ", number=" + number + "]";
	}
}
