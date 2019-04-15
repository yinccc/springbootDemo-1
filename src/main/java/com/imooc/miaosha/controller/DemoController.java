package com.imooc.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.redis.UserKey;
import com.imooc.miaosha.service.UserService;

import om.imooc.miaosha.result.CodeMsg;
import om.imooc.miaosha.result.Result;

@Controller
@RequestMapping("/demo")
public class DemoController {
		@Autowired
		RedisService redisService;
		
		@Autowired
		UserService userService;
	
		@RequestMapping("/")
		@ResponseBody
		String home() {
			return "Hello World!";
		}
		//1.rest api json输出
		@RequestMapping("/hello")
		@ResponseBody
		public Result<String> hello() {
			return Result.success("hello,imooc");
		}
		
		@RequestMapping("/helloError")
		@ResponseBody
		public Result<String> helloError() {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
		
		
		@RequestMapping("/thymeleaf")
		public String thymeleaf(Model model) {
			model.addAttribute("name","yinchang");
			return "hello";
		}
		
		@RequestMapping("/db/get")
		@ResponseBody
		public Result<User> dbGet() {
			User user=userService.getById(1);
			return Result.success(user);
		}
		
		@RequestMapping("/db/tx")
		@ResponseBody
		public Result<Boolean> dbTx() {
			userService.tx();
			return Result.success(true);
		}
		
		@RequestMapping("/redis/get")
		@ResponseBody
		public Result<User> redisGet() {
			User user=redisService.get(UserKey.getById,""+1,User.class);
			return Result.success(user);
		}
		
		@RequestMapping("/redis/set")
		@ResponseBody
		public Result<Boolean> redisSet() {
			User user=new User();
			user.setId(1);
			user.setName("1111");
			redisService.set(UserKey.getById,""+1,user);
			return Result.success(true);
		}
		
		
	
}
