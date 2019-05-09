package weixinkeji.vip.expand.poi.test.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import weixinkeji.vip.expand.poi.JWEOffice;

public class User {
	@JWEOffice
	private Integer id;
	@JWEOffice(title="用户名",sort=2)
	private String userName;
	@JWEOffice(title="用年龄",sort=3)
	private int userAge;
	@JWEOffice(title="工资" ,sort=7)
	private double userMoney;
	@JWEOffice(title="性别" ,sort=4)
	private short userSex;
	@JWEOffice(title="生日" ,sort=5)
	private Date userBirthday;
	@JWEOffice(title="创建时间" ,sort=1,dateformat="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	@Override
	public String toString() {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  
				"id="+id
				+",userName="+userName
				+",userAge="+userAge
				+",userMoney="+userMoney
				+",userSex="+userSex
				+",userBirthday="+(null!=this.userBirthday?sf.format(this.userBirthday):"")
				+",createTime="+(null!=this.createTime?sf.format(this.createTime):"");
				
	}
	
	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(double userMoney) {
		this.userMoney = userMoney;
	}

	public short getUserSex() {
		return userSex;
	}

	public void setUserSex(short userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
