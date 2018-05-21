package com.sgg.rest.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Repair {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@ManyToOne(targetEntity = ApplicationUser.class)
	@JoinColumn(name="user_id")
	@JsonBackReference
    private ApplicationUser applicationUser;
	@Column(name ="content",length=1024)
    private String content;
    private Integer area;
    private String address;
    private String telephone;
    private Integer repair_status;
    @OneToOne(cascade=CascadeType.ALL)
    private ApplicationUser repairman;
    private String material;
	@Column(name ="result",length=1024)
    private String result;
    private String rate;
    private String isEvaluate = "n";
    private String is_vaild ="y";
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date repair_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date update_time;
	@Column(name ="comments",length=1024)
	private String comments;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ApplicationUser getApplicationUser() {
		return applicationUser;
	}
	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getRepair_status() {
		return repair_status;
	}
	public void setRepair_status(Integer repair_status) {
		this.repair_status = repair_status;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public ApplicationUser getRepairman() {
		return repairman;
	}
	public void setRepairman(ApplicationUser repairman) {
		this.repairman = repairman;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getIsEvaluate() {
		return isEvaluate;
	}
	public void setIsEvaluate(String isEvaluate) {
		this.isEvaluate = isEvaluate;
	}
	public String getIs_vaild() {
		return is_vaild;
	}
	public void setIs_vaild(String is_vaild) {
		this.is_vaild = is_vaild;
	}
	public Date getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(Date repair_time) {
		this.repair_time = repair_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
