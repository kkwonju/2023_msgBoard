package com.kkwo.msgBoard.demo.vo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRequestDto {
	
	@RequestMapping("/")
	public String sayHello() {
		return "usr/article/main";
	}
}