package com.zyt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_person")
public class GroupPerson implements Serializable {
	private static final long serialVersionUID = 9187554354928135579L;
	@Id
	@Column(name = "gpid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gpid;
	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "pid")
	private Person person;
	@ManyToOne(targetEntity = Group.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "gid")
	private Group group;
	@Column(name = "permitted")
	private boolean permitted;

	public int getGpid() {
		return gpid;
	}

	public void setGpid(int gpid) {
		this.gpid = gpid;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isPermitted() {
		return permitted;
	}

	public void setPermitted(boolean permitted) {
		this.permitted = permitted;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gpid;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupPerson other = (GroupPerson) obj;
		if (gpid != other.gpid)
			return false;
		return true;
	}
}
