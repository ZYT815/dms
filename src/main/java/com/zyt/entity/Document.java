package com.zyt.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document implements Serializable {
	private static final long serialVersionUID = 4854137206099450092L;
	@Id
	@Column(name="did")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String did;
	@Column(name="ddata")
	private Blob ddata;
	@OneToOne(targetEntity=Group.class)
	private Group group;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public Blob getDdata() {
		return ddata;
	}

	public void setDdata(Blob ddata) {
		this.ddata = ddata;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		return true;
	}
}
