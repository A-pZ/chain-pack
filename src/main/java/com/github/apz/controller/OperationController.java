package com.github.apz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.apz.service.operation.OperationSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/operation")
@RequiredArgsConstructor
public class OperationController {
	final OperationSearchService service;


}
