package com.znsd.restaurant.bean;

//用户
public class UserBean {
    private int id;//用户id
    private String loginName;//用户名
    private String loginPwd;//密码
    private String trueName;//真实姓名
    private String email;//
    private String phone;
    private String address;
    private String createTime;//创建时间
    private double money;//消费总金额

    public UserBean() {
    }

    public UserBean(String loginName, String loginPwd, String trueName, String email, String phone, String address) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.trueName = trueName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UserBean(int id, String loginName, String loginPwd, String trueName, String email, String phone, String address, String createTime, double money) {
        this.id = id;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.trueName = trueName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createTime = createTime;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", trueName='" + trueName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createTime='" + createTime + '\'' +
                ", money=" + money +
                '}';
    }
}
