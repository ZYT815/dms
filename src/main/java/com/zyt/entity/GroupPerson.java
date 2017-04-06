package com.zyt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_person")
public class GroupPerson implements Serializable {
	private static final long serialVersionUID = 9187554354928135579L;
	@Id
	@Column(name = "gpid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gpid;
	@OneToOne(targetEntity = Person.class)
	private Person person;
	@OneToOne(targetEntity = Group.class)
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
}
