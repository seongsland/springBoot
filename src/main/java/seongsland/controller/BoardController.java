package seongsland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import seongsland.domain.User;
import seongsland.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping({"", "/"})
	public String board() {
		return "/board/form";
	}

	@GetMapping("/list")
	public String list() {
		return "/board/list";
	}

}