package pack180801_jdbc;

import java.sql.Date;

public class JDBC06_Person {
	/**
	 * 一般情况下，字段名和属性名都一致
	 * 如getId方法将I小写，为id，为树形
	 * this.id中id为字段（成员变量）
	 * */
	public JDBC06_Person() {
		super();
	}
	public JDBC06_Person(int id, String name, int age, String sex, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birth = birth;
	}
	private int id;
	private String name;
	private int age;
	private String sex;
	private Date birth;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String toString(){
		return this.id+" "+this.name+" "+this.age+" "+this.sex+" "+this.birth;
	}
}
