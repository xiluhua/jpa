package com.query;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer2 {

	private Integer id;
	private String lastName;

	private String city;
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Customer2() {
		// TODO Auto-generated constructor stub
	}
	public Customer2(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Id
//	@Column(name="")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
    
}
