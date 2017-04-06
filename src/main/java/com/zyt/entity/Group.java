package com.zyt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="group")
public class Group implements Serializable {

	private static final long serialVersionUID = -6555569616016710558L;

	@Id
	@Column(name="gid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gid;
	@Column(name="gname")
	private String gname;
	@OneToMany(targetEntity=Document.class)
	private List<Document> documents;
	@OneToMany(targetEntity=GroupPerson.class)
	private List<GroupPerson>groupPersons;

	public List<GroupPerson> getGroupPersons() {
		return groupPersons;
	}

	public void setGroupPersons(List<GroupPerson> groupPersons) {
		this.groupPersons = groupPersons;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gid;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (gid != other.gid)
			return false;
		return true;
	}
}
