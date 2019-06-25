package com.znsd.restaurant.bean;

//订单
public class IndentBean {
	private int indentId;//下单id
	private String indentName;//下单名
	private String userName;//下单用户
	private String indentTime;//下单时间
	private String menuName;//下单菜谱
	private String status;//订单状态
	private Double money;//金额
	public IndentBean() {
		super();
	}
	public IndentBean(int indentId,String indentName, String userName,String menuName, String indentTime ,String status,Double money) {
		super();
		this.indentId = indentId;
		this.indentName = indentName;
		this.userName = userName;
		this.indentTime = indentTime;
		this.menuName = menuName;
		this.status = status;
		this.money = money;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIndentName() {
		return indentName;
	}
	public void setIndentName(String indentName) {
		this.indentName = indentName;
	}
	public int getIndentId() {
		return indentId;
	}
	public void setIndentId(int indentId) {
		this.indentId = indentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIndentTime() {
		return indentTime;
	}
	public void setIndentTime(String indentTime) {
		this.indentTime = indentTime;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "Indent [indentId=" + indentId + ", userName=" + userName + ", indentTime=" + indentTime + ", menuName="
				+ menuName + "]";
	}
}
