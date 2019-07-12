package com.sample.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.web.entity.User;

@Controller
public class TestController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome(ModelMap map) {
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
		
		subject.login(token);
		
		User principal = (User) subject.getPrincipal();
		
		map.addAttribute("data", principal);
		return "welcome";
	}
	
	@RequestMapping("/home")
	public String home(ModelMap map) {
		map.addAttribute("data", "隐私数据");
		return "home";
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized(ModelMap map) {
		return "unauthorized";
	}

}
