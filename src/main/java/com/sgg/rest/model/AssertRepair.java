package com.sgg.rest.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AssertRepair {
	private Integer id;
	private String name;
	private Integer area;
	private String  address;
	private Integer repair_status;
	private String  content;
	private String telephone;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;

	public AssertRepair(Integer id, String name, Integer area, String address, Integer repair_status, String content,
			String telephone, Date create_time) {
		this.id = id;
		this.name = name;
		this.area = area;
		this.address = address;
		this.repair_status = repair_status;
		this.content = content;
		this.telephone = telephone;
		this.create_time = create_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getRepair_status() {
		return repair_status;
	}
	public void setRepair_status(Integer repair_status) {
		this.repair_status = repair_status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
}
