package com.xaver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@OneToOne(targetEntity=SiteUser.class)
	@JoinColumn(name="user_id", nullable=false)
	private SiteUser user;
	
	@Column(name="about", length=5000)
	private String about;
}
