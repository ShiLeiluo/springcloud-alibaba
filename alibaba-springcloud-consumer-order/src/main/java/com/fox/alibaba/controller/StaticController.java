package com.fox.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 16:37
* @version 1.0
*/
@Controller
public class StaticController {
	@RequestMapping("/main.html")
	public String main() {
		return "html/main";
	}
}
