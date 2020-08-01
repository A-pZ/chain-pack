package com.github.apz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@RequestMapping("")
@Log4j2
public class IndexController {

	@GetMapping("")
	public ModelAndView display(ModelAndView mnv) {

		mnv.setViewName("index");
		return mnv;
	}
}
