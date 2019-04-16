package com.nba.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nba.service.PlayerService;

@Controller
public class PlayerController {
	
	@Resource
	private PlayerService playerServiceImpl;
	@RequestMapping("show")
	public String show(Model model){
		model.addAttribute("list", playerServiceImpl.show());
		return "index.jsp";
	}
	
}
