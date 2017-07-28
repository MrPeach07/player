package com.Lizhiyu.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lzy on 17-7-28.
 */
@Entity
public class Player {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String club;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Player() {
	}
}
