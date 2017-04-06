package com.zyt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Person implements Serializable {

	private static final long serialVersionUID = -748092142509995559L;
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int pid;
	@Column(name = "pname")
	private String pname;
	@Column(name = "ppass")
	private String ppass;
	@OneToMany(targetEntity = GroupPerson.class)
	private List<GroupPerson> groupPersons;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPpass() {
		return ppass;
	}

	public void setPpass(String ppass) {
		this.ppass = ppass;
	}

	public List<GroupPerson> getGroupPersons() {
		return groupPersons;
	}

	public void setGroupPersons(List<GroupPerson> groupPersons) {
		this.groupPersons = groupPersons;
	}

}
