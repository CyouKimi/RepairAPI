package com.sgg.rest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class RepairRecord {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@ManyToOne(targetEntity = Repair.class)
	@JoinColumn(name="repair_id")
    private Repair repair;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String repair_progress;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date update_time;
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
	public String getRepair_progress() {
		return repair_progress;
	}
	public void setRepair_progress(String repair_progress) {
		this.repair_progress = repair_progress;
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
	
}
