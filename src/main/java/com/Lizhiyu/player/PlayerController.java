package com.Lizhiyu.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Lizhiyu.player.Player;
import com.Lizhiyu.player.PlayerRepository;

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
	public Player playerAdd(@RequestParam("id") Integer id,
							@RequestParam("name") String name,
							@RequestParam("club") String club) {
		Player player = new Player();
		player.setId(id);
		player.setClub(club);
		player.setName(name);

		return playerRepository.save(player);
	}


	/**
	 * 通过id查询球员信息
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/players/{id}")
	public Player playerGetOne(@PathVariable("id") Integer id) {
		return playerRepository.getOne(id);
	}

	/**
	 * 更新球员
	 * @param id
	 * @param name
	 * @param club
	 * @return
	 */
	@PutMapping(value = "/players/{id}")
	public Player playerUpdate(@PathVariable("id") Integer id,
							 @RequestParam("name") String name,
							 @RequestParam("club") String club) {
		Player player = new Player();
		player.setId(id);
		player.setName(name);
		player.setClub(club);

		return playerRepository.save(player);
	}

	/**
	 * 根据id删除球员信息
	 * @param id
	 */
	@DeleteMapping(value = "/players/{id}")
	public void playersDelete(@PathVariable("id") Integer id) {
		playerRepository.deleteById(id);
	}


	/**
	 * 根据club查询球员信息
	 * @param club
	 * @return
	 */
	@GetMapping(value = "/players/club/{club}")
	public List<Player> playerListByClub(@PathVariable("club") String club) {
		return playerRepository.findByClub(club);
	}

}
