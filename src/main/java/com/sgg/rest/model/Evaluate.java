package com.sgg.rest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Evaluate {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade=CascadeType.ALL)
    private Repair repair;
    private Integer rate;
    private Integer workload;
	@Column(name ="comments",length=1024)
	private String comments;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Repair getRepair() {
		return repair;
	}
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getWorkload() {
		return workload;
	}
	public void setWorkload(Integer workload) {
		this.workload = workload;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
