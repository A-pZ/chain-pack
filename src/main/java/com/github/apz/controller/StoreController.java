package com.github.apz.controller;

import java.util.List;
import java.util.Objects;

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
import com.github.apz.model.store.StoreRelation;
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
	public ModelAndView findStoreRelation(ModelAndView mnv, @PathVariable("storeId") Long storeId, RedirectAttributes redirects) {
		Store store = service.findStore(Store.of(storeId));
		if (Objects.isNull(store)) {
			redirects.addFlashAttribute("message", "存在しない店舗コードです");
			mnv.setViewName("redirect:/store/all");
			return mnv;
		}
		mnv.addObject("store", store);

		List<StoreRelation> relation = service.findStoreRelation(Store.of(storeId));
		mnv.addObject("relations", relation);

		mnv.setViewName("relation");
		return mnv;
	}

	@PostMapping("/{storeId}")
	public ModelAndView updateStoreName(ModelAndView mnv,
			@PathVariable("storeId") Long storeId,
			@RequestParam("storeName") String storeName,
			RedirectAttributes redirects) {

		service.updateStoreName(Store.of(storeId, storeName));

		redirects.addFlashAttribute("message", "店舗名を更新しました");
		mnv.setViewName("redirect:/store/relation/" + storeId.toString());
		return mnv;
	}

}