package com.github.apz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.operation.OperationLog;
import com.github.apz.service.operation.OperationSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/operation")
@RequiredArgsConstructor
public class OperationController {
	final OperationSearchService service;

	@GetMapping("/all")
	public ModelAndView findAll(ModelAndView mnv, RedirectAttributes redirects) {

		List<OperationLog> result = service.findOperationLog();

		mnv.addObject("operations", result);
		mnv.setViewName("operation");
		return mnv;
	}
}
