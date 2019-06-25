package com.znsd.restaurant.bean;

import java.util.Date;

//菜谱
public class MenuBean {
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	private int menuId;//菜谱id
	private String menuName;//菜谱名称
	private double price;//价格
	private int vegetableId;//菜系id
	public int getVegetableId() {
		return vegetableId;
	}
	public MenuBean(int menuId, String menuName, double price, int vegetableId, String picture, int userCount, int good,
			int general, int bad, Date addTime, String menuType, String describe) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.vegetableId = vegetableId;
		this.picture = picture;
		this.userCount = userCount;
		this.good = good;
		this.general = general;
		this.bad = bad;
		this.addTime = addTime;
		this.menuType = menuType;
		this.describe = describe;
	}
	public void setVegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
	}
	private String vegetableName;//菜系名称
	private String picture;//图片地址
	private int userCount;//用户购买量
	private int good;//好评数量
	private int general;//一般数量
	private int bad;//差评数量
	private Date addTime;//增加时间
	private String menuType;//菜谱类型
	private String describe;//描述
	public MenuBean() {
		super();
	}
	
	public MenuBean(String menuName, double price, String vegetableName, String menuType, String describe) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.vegetableName = vegetableName;
		this.menuType = menuType;
		this.describe = describe;
	}
	public MenuBean(int menuId, String menuName, double price, String vegetableName, String picture, int userCount, int good,
			int general, int bad, Date addTime,String menuType,String describe) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.vegetableName = vegetableName;
		this.picture = picture;
		this.userCount = userCount;
		this.good = good;
		this.general = general;
		this.bad = bad;
		this.addTime = addTime;
		this.menuType = menuType;
		this.describe=describe;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVegetableName() {
		return vegetableName;
	}
	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getGeneral() {
		return general;
	}
	public void setGeneral(int general) {
		this.general = general;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", price=" + price + ", vegetableId=" + vegetableName
				+ ", picture=" + picture + ", userCount=" + userCount + ", godd=" + good + ", general=" + general
				+ ", bad=" + bad + ", addTime=" + addTime + ", menuType=" + menuType + "]";
	}
}
