package com.nba.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.nba.bean.Player;
import com.nba.dao.PlayerDao;
import com.nba.service.PlayerService;

public class PlayerServiceImpl implements PlayerService{

	@Resource
	private PlayerDao playerDao;
	@Override
	public List<Player> show() {
		
		return playerDao.selAll();
	}

}
