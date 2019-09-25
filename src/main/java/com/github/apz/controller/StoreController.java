package com.github.apz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.store.Store;
import com.github.apz.service.store.StoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
	final StoreService service;

	@GetMapping("/all")
	public ModelAndView findAllStore(ModelAndView mnv, @ModelAttribute("message") String message) {
		if (StringUtils.isEmpty(message)) {
			message = "検索が完了しました";
		}

		List<Store> stores = service.findAllStore();
		mnv.addObject("stores", stores);
		mnv.setViewName("store");
		return mnv;
	}

	@PostMapping("/")
	public ModelAndView register(ModelAndView mnv, @RequestParam("name") String name, RedirectAttributes redirects) {
		service.register(Store.newStore(name));
		redirects.addFlashAttribute("message", "登録が完了しました");
		mnv.setViewName("redirect:/store/all");
		return mnv;
	}

	@GetMapping("/relation/{storeId}")
	public ModelAndView findStoreRelation(ModelAndView mnv, @PathVariable("storeId") Long storeId) {
		List<Store> relation = service.findStoreRelation(Store.of(storeId));
		mnv.addObject("relation", relation);
		mnv.setViewName("relation");
		return mnv;
	}
}
