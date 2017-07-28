package com.Lizhiyu.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lzy on 17-7-28.
 */
@RestController
public class HelloController {

	@Autowired
	private PlayerProperties playerProperties;

	@RequestMapping(value = "/say",method = RequestMethod.GET)
	public String say() {
		return playerProperties.getClub();
	}
}
