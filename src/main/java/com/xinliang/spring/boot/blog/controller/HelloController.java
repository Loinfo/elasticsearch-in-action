package com.xinliang.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello 控制器
 * @since 
 * @author liangxin
 *
 */
@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}
}
