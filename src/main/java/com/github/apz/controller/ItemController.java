package com.github.apz.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.item.Item;
import com.github.apz.model.store.Store;
import com.github.apz.service.item.ItemService;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

	final ItemService service;

	@GetMapping("/all")
	public ModelAndView all(ModelAndView mnv, @ModelAttribute("message") String message) {
		List<Item> items = service.findAllItems();
		mnv.addObject("items", items);
		if (StringUtils.isEmpty(message)) {
			message = "検索が完了しました";
		}
		mnv.addObject("message", message);

		mnv.setViewName("item");
		return mnv;
	}

	@GetMapping("/store")
	public ModelAndView storeItems(
			@RequestParam(value="storeName", required=false) String storeName,
			@RequestParam(value="storeId", required=false) Long storeId,
			ModelAndView mnv, @ModelAttribute("message") String message) {
		List<Item> items = findStoreItems(storeName, storeId);

		if (StringUtils.isEmpty(message)) {
			message = "検索が完了しました";
		}

		mnv.addObject("items", items);
		mnv.addObject("message", message);
		mnv.setViewName("item");
		return mnv;
	}

	@PostMapping("/")
	public ModelAndView register(@RequestParam("name") String name, ModelAndView mnv, RedirectAttributes redirects) {
		service.register(Item.newItem(name));
		redirects.addFlashAttribute("message", "登録が完了しました");
		mnv.setViewName("redirect:/item/all");
		return mnv;
	}

	@PutMapping("/{storeId}/{name}")
	public ModelAndView update(@PathVariable("storeId") Long storeId, @PathVariable("name") String name, ModelAndView mnv, RedirectAttributes redirects) {
		redirects.addFlashAttribute("message", "更新が完了しました");
		mnv.setViewName("redirect:/item/all");
		return mnv;
	}

	private List<Item> findStoreItems(String storeName, Long storeId) {
		if (StringUtils.isNotEmpty(storeName)) {
			return service.findStoreItems(Store.of(storeName));
		}

		if (!Objects.isNull(storeId)) {
			return service.findStoreItems(Store.of(storeId));
		}

		return Collections.emptyList();
	}
}
