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
@Table
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
}
