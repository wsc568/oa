package com.wsc.oa.identity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="OA_ID_MODULE")
public class Module implements Serializable{
	@Id @Column(name="CODE" , length=100)
	private String code;
	
	@Column(name="NAME" , length=50)
	private String name;
	
	@Column(name="URL" , length=100)
	private String url;
	
	@Column(name="REMARK" , length=500)
	private String remark;
	
	//模块修改人与用户存在多对一关系 fk（OA_ID_USER）
	@ManyToOne(fetch=FetchType.LAZY , targetEntity=User.class)
	@JoinColumn(name="MODIFIER" , referencedColumnName="USER_ID" , 
				foreignKey=@ForeignKey(name="FK_MODULE_MODEFIER"))
	private User modifier;
	
	//模块创建人与用户存在多对一关系 fk（OA_ID_USER）
	@ManyToOne(fetch=FetchType.LAZY , targetEntity=User.class)
	@JoinColumn(name="CREATER" , referencedColumnName="USER_ID" , 
				foreignKey=@ForeignKey(name="FK_MODULE_CREATER"))
	private User creater;
	
	@Column(name="MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Module [code=" + code + ", name=" + name + ", url=" + url + ", remark=" + remark + ", modifier="
				+ modifier + ", creater=" + creater + ", modifyDate=" + modifyDate + ", createDate=" + createDate + "]";
	}
	
	
}
