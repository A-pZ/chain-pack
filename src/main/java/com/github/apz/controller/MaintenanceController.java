package com.github.apz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.service.maintenance.MaintenanceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {

	final MaintenanceService service;

	@GetMapping("/")
	public ModelAndView display(ModelAndView mnv, @ModelAttribute("message") String message) {
		mnv.addObject("message", message);
		mnv.setViewName("maintenance");
		return mnv;
	}

	@GetMapping("/item/deposit/reset")
	public ModelAndView allResetItemDeposit(ModelAndView mnv, RedirectAttributes redirects) {
		service.deleteItemDeposit();
		mnv.setViewName("redirect:/maintenance/");
		redirects.addAttribute("message", "すべての商品を拠点から削除しました。");
		return mnv;
	}

	@GetMapping("/store/relation/reset")
	public ModelAndView allResetStoreRelation(ModelAndView mnv, RedirectAttributes redirects) {
		service.deleteStoreRelation();
		mnv.setViewName("redirect:/maintenance/");
		redirects.addAttribute("message", "すべての拠点連携を削除しました。");
		return mnv;
	}

	@GetMapping("/operation/reset")
	public ModelAndView allResetOperation(ModelAndView mnv, RedirectAttributes redirects) {
		service.deleteOperationLog();
		mnv.setViewName("redirect:/maintenance/");
		redirects.addAttribute("message", "すべての操作ログ削除しました。");
		return mnv;
	}

	@GetMapping("/item/clear")
	public ModelAndView allItemClear(ModelAndView mnv, RedirectAttributes redirects) {
		service.deleteAllItem();
		mnv.setViewName("redirect:/maintenance/");
		redirects.addAttribute("message", "すべての商品を削除しました。");
		return mnv;
	}

	@GetMapping("/store/clear")
	public ModelAndView allStoreClear(ModelAndView mnv, RedirectAttributes redirects) {
		service.deleteAllStore();
		mnv.setViewName("redirect:/maintenance/");
		redirects.addAttribute("message","すべての拠点を削除しました。");
		return mnv;
	}
}
