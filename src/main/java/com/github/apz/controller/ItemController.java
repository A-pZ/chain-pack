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

	@GetMapping("/{itemId}")
	public ModelAndView itemEdit(ModelAndView mnv, @PathVariable("itemId") Long itemId, @ModelAttribute("message") String message) {
		Item item = service.findItem(Item.of(itemId));
		if (StringUtils.isEmpty(message)) {
			message = "商品の詳細を表示します";
		}
		mnv.addObject("item", item);
		mnv.addObject("message", message);
		mnv.setViewName("itemDetail");
		return mnv;
	}

	@PostMapping("/{itemId}")
	public ModelAndView itemUpdate(ModelAndView mnv, @PathVariable("itemId") Long itemId, @RequestParam("name") String name, @ModelAttribute("message") String message, RedirectAttributes redirects) {
		if (StringUtils.isEmpty(name)) {
			redirects.addFlashAttribute("message", "商品名を入力してください");
			mnv.setViewName("redirect:/item/" + itemId.toString());
			return mnv;
		}

		Item item = service.findItem(Item.of(itemId));
		if (Objects.isNull(item)) {
			redirects.addFlashAttribute("message", "存在しない商品コードです");
			mnv.setViewName("redirect:/item/" + itemId.toString());
			return mnv;
		}

		service.updateItem(Item.updateItem(itemId, name));

		redirects.addFlashAttribute("message", "商品名の更新が完了しました");
		mnv.setViewName("redirect:/item/" + itemId.toString());
		return mnv;
	}

	@PostMapping("/")
	public ModelAndView register(@RequestParam("name") String name, ModelAndView mnv, RedirectAttributes redirects) {
		if (StringUtils.isEmpty(name)) {
			mnv.setViewName("redirect:/item/all");
			return mnv;
		}
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
