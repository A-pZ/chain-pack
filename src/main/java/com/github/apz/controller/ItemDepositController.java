package com.github.apz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.item.ItemDeposit;
import com.github.apz.service.item.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemDepositController {

	final ItemService service;

	@PostMapping("/{itemId}/storeId/{storeId}")
	public String deposit(ModelAndView mnv,
			@PathVariable("itemId") Long itemId,
			@PathVariable("storeId") Long storeId,
			@RequestParam("deposit") boolean deposit,
			RedirectAttributes redirects) {

		service.updateItemDeposit(ItemDeposit.of(storeId, itemId, deposit));

		return "success";
	}
}
