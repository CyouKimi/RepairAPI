package com.sgg.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "codeType")
public class CodeType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String code;
    private String name;
    @OneToMany(mappedBy = "type",fetch=FetchType.EAGER)
    private Set<CodeData> codeDataSet=new HashSet<CodeData>(); // 集合
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Set<CodeData> getCodeDataSet() {
		return codeDataSet;
	}
	public void setCodeDataSet(Set<CodeData> codeDataSet) {
		this.codeDataSet = codeDataSet;
	}
    
}
