package com.zyt.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "document")
public class Document implements Serializable {
	private static final long serialVersionUID = 4854137206099450092L;
	@Id
	@Column(name = "did")
	@GeneratedValue(generator = "did")
	@GenericGenerator(name = "did", strategy = "uuid")
	private String did;
	@Column(name = "ddata")
	private Blob ddata;
	@Column(name = "dname")
	private String dname;
	@ManyToOne(targetEntity = Group.class)
	@JoinColumn(name = "gid")
	private Group group;
	@Column(name = "updateDate")
	private Date updateDate;

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
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
		Document other = (Document) obj;
		if (did == null) {
			if (other.did != null) {
				return false;
			}
		} else if (!did.equals(other.did)) {
			return false;
		}
		return true;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
