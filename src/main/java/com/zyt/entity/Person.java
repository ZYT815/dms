package com.zyt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = -748092142509995559L;
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column(name = "pname")
	private String pname;
	@Column(name = "ppass")
	private String ppass;
	@OneToMany(targetEntity = GroupPerson.class, cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.EAGER)
	private Set<GroupPerson> groupPersons;

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

	public Set<GroupPerson> getGroupPersons() {
		return groupPersons;
	}

	public void setGroupPersons(Set<GroupPerson> groupPersons) {
		this.groupPersons = groupPersons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (pid != other.pid) {
			return false;
		}
		return true;
	}

}
