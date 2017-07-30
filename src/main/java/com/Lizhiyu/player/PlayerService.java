package com.Lizhiyu.player;

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
		playerRepository.save(playerA);

		Player playerB = new Player();
		playerB.setId(10);
		playerB.setName("Messi");
		playerB.setClub("Barcelona");
		playerRepository.save(playerB);
	}
}
