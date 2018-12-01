package com.wsc.oa.identity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="OA_ID_JOB")
public class Job implements Serializable{
	@Id @Column(name="CODE" , length=100)
	private String code;
	
	@Column(name="NAME" , length=50)
	private String name;
	
	@Column(name="REMARK" , length=300)
	private String remark;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Job [code=" + code + ", name=" + name + ", remark=" + remark + "]";
	}
	
	
	
}
