package com.Lizhiyu.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzy on 17-7-28.
 */
@RestController
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;


	/**
	 * 查询所有球员列表
	 * @return
	 */
	@GetMapping(value = "/players")
	public List<Player> PlayerList() {
		return playerRepository.findAll();
	}

	/**
	 * 添加一个球员
	 * @param id
	 * @param name
	 * @param club
	 * @return 球员对象
	 */
	@PostMapping(value = "/players")
	public Player playerAdd(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("club") String club) {
		Player player = new Player();
		player.setId(id);
		player.setClub(club);
		player.setName(name);

		 return playerRepository.save(player);
	}

	//根据id查询一个球员
	@GetMapping(value = "/players/{id}")
	public Player playerFindOne(@PathVariable("id") Integer id) {
		return playerRepository.findOne(id);
	}

	//更新
	/*@PutMapping(value = "/players/{id}")
	//删除
	@DeleteMapping(value = "/players/{id}")*/

}
