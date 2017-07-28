package com.Lizhiyu.player;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lzy on 17-7-28.
 */
@ConfigurationProperties(prefix = "player")
@Component
public class PlayerProperties {

	private String name;

	private String club;

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
}
