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
@Table(name = "t_group")
public class Group implements Serializable {

	private static final long serialVersionUID = -6555569616016710558L;

	@Id
	@Column(name = "gid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gid;
	@Column(name = "shareId")
	private String shareId;
	@Column(name = "gname")
	private String gname;
	@OneToMany(targetEntity = Document.class, cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.EAGER)
	private Set<Document> documents;
	@OneToMany(targetEntity = GroupPerson.class, cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.EAGER)
	private Set<GroupPerson> groupPersons;

	public Set<GroupPerson> getGroupPersons() {
		return groupPersons;
	}

	public void setGroupPersons(Set<GroupPerson> groupPersons) {
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

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gid;
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
		Group other = (Group) obj;
		if (gid != other.gid) {
			return false;
		}
		return true;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
}
