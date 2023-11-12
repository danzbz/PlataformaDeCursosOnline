package com.projects.plataformaDeCursosOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@SpringBootApplication
@EnableSwagger2
public class PlataformaDeCursosOnlineApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaDeCursosOnlineApplication.class, args);
		
	}
	
	@RequestMapping ("/")
	@ResponseBody
	String home()
	{
		return "Hello World";
		}
	
	
}
