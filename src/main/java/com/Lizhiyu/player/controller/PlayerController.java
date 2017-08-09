package com.Lizhiyu.player.controller;

import com.Lizhiyu.player.aspect.HttpAspect;
import com.Lizhiyu.player.domain.Result;
import com.Lizhiyu.player.service.PlayerService;
import com.Lizhiyu.player.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.Lizhiyu.player.domain.Player;
import com.Lizhiyu.player.repository.PlayerRepository;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by lzy on 17-7-28.
 */
@RestController
public class PlayerController {

	private final static Logger logger = LoggerFactory.getLogger(PlayerController.class);


	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService playerService;


	/**
	 * 查询所有球员列表
	 * @return
	 */
	@GetMapping(value = "/players")
	public List<Player> playerList() {
		logger.info("playerList");
		return playerRepository.findAll();
	}

	/**
	 * 添加一个球员
	 * @return 球员对象
	 */
	@PostMapping(value = "/players")
	public Result<Player> playerAdd(@Valid Player player, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return null;
			//			return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
		}

			player.setName(player.getName());
			player.setClub(player.getClub());
			player.setAge(player.getAge());

			return ResultUtil.success(playerRepository.save(player));

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
							 @RequestParam("club") String club,
							 @RequestParam("age") Integer age) {
		Player player = new Player();
		player.setId(id);
		player.setName(name);
		player.setClub(club);
		player.setAge(age);

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

	/**
	 *一次插入两条数据事务方法的调用
	 */
	@PostMapping(value = "/players/two")
	public void playerTwo() {
		playerService.insertTwo();
	}

	@GetMapping(value = "players/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		playerService.getAge(id);
	}
}
