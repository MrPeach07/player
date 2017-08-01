package com.Lizhiyu.player.service;

import com.Lizhiyu.player.exception.PlayerException;
import com.Lizhiyu.player.repository.PlayerRepository;
import com.Lizhiyu.player.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lzy on 17-7-30.
 */
@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Transactional
	public  void insertTwo() {
		Player playerA = new Player();
		playerA.setId(9);
		playerA.setName("Benzema");
		playerA.setClub("RealMadrid");
		playerA.setAge(25);
		playerRepository.save(playerA);

		Player playerB = new Player();
		playerB.setId(10);
		playerB.setName("Messi");
		playerB.setClub("Barcelona");
		playerB.setAge(28);
		playerRepository.save(playerB);
	}

	public void getAge(Integer id) throws Exception{
		Player player = playerRepository.getOne(id);
		Integer age = player.getAge();
		if(age<13) {
			//返回球员还在青训期间,code = 101
			throw new PlayerException(101,"球员还在青训期间");
		}
		else if(age > 13 &&age < 18){
			//返回球员在国家联赛踢球了,code = 100
			throw new PlayerException(100,"球员在国家联赛踢球了");
		}

	}
}
