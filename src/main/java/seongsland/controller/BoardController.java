package seongsland.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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