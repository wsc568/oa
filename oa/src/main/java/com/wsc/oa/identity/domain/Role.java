package com.wsc.oa.identity.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="OA_ID_ROLE")
public class Role implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME" , length=50)
	private String name;
	
	@Column(name="REMARK" , length=500)
	private String remark;
	
	//角色创建人与用户存在多对一关系fk(OA_ID_USER)
	@ManyToOne(fetch=FetchType.LAZY , targetEntity=User.class)
	@JoinColumn(name="CREATER" , referencedColumnName="USER_ID" , 
				foreignKey=@ForeignKey(name="FK_ROLE_CREATER"))
	private User creater;
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	//角色修改人与用户存在多对一关系fk(OA_ID_USER)
	@ManyToOne(fetch=FetchType.LAZY , targetEntity=User.class)
	@JoinColumn(name="MODIFIER" , referencedColumnName="USER_ID" , 
				foreignKey=@ForeignKey(name="FK_ROLE_MODIFIER"))
	private User modifier;
	
	@Column(name="MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	//角色与用户存在多对多关系
	@ManyToMany(fetch=FetchType.LAZY , targetEntity=User.class)
	@JoinTable(name="OA_ID_USER_ROLE" , joinColumns=@JoinColumn(name="ROLE_ID" , referencedColumnName="ID")	, 
				inverseJoinColumns=@JoinColumn(name="USER_ID" , referencedColumnName="USER_ID"))
	private Set<User> users = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", remark=" + remark + ", creater=" + creater + ", createDate="
				+ createDate + ", modifier=" + modifier + ", modifyDate=" + modifyDate + ", users=" + users + "]";
	}
	
	
	
	
}
