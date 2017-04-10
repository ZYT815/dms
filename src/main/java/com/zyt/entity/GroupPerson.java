package com.zyt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "group_person")
public class GroupPerson implements Serializable {
	private static final long serialVersionUID = 9187554354928135579L;
	@Id
	@Column(name = "gpid")
	@GeneratedValue(generator = "id_combination")
	@GenericGenerator(name = "id_combination", strategy = "com.zyt.util.generator.GroupPersonIdCombinationGenernaterStrategy")
	private String gpid;
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "pid")
	private Person person;
	@ManyToOne(targetEntity = Group.class)
	@JoinColumn(name = "gid")
	private Group group;
	@Column(name = "permitted")
	private boolean permitted;

	public String getGpid() {
		return gpid;
	}

	public void setGpid(String gpid) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gpid == null) ? 0 : gpid.hashCode());
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
		GroupPerson other = (GroupPerson) obj;
		if (gpid == null) {
			if (other.gpid != null) {
				return false;
			}
		} else if (!gpid.equals(other.gpid)) {
			return false;
		}
		return true;
	}

}
