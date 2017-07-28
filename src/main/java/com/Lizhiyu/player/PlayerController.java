package com.Lizhiyu.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lzy on 17-7-28.
 */
@RestController
public class PlayerController {

	@Autowired
	private PlayerProperties playerProperties;

	@GetMapping(value = "/players")
	public List<Player> PlayerList() {
		return playerProperties.findAll();
	}
}
