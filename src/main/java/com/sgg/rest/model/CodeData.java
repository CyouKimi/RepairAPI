package com.sgg.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CodeData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@ManyToOne(targetEntity = CodeType.class)
	@JoinColumn(name="type")
	private CodeType type;
	private String code;
    private String name;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CodeType getType() {
		return type;
	}
	public void setType(CodeType type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
