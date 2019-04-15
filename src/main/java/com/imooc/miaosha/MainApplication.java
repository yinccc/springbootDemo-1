package com.imooc.miaosha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imooc.miaosha.controller.DemoController;


@SpringBootApplication
public class MainApplication {
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(MainApplication.class, args);
	}
}
