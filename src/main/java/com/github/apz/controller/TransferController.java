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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.item.Item;
import com.github.apz.model.store.Store;
import com.github.apz.model.store.StoreRelation;
import com.github.apz.service.item.ItemService;
import com.github.apz.service.store.StoreService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/transfer")
@Controller
@RequiredArgsConstructor
public class TransferController {

	final StoreService storeService;
	final ItemService itemService;

	@GetMapping("/stores")
	public ModelAndView storeSelect(ModelAndView mnv) {

		List<Store> stores = storeService.findAllStore();

		mnv.addObject("stores", stores);
		mnv.setViewName("storeSelect");
		return mnv;
	}

	@GetMapping("/store/{storeId}/items")
	public ModelAndView itemSelect(
			ModelAndView mnv,
			@PathVariable("storeId") Long storeId,
			RedirectAttributes redirects,
			@ModelAttribute("message") String message
		) {
		List<Item> items = itemService.findStoreItems(Store.of(storeId));

		if (StringUtils.isEmpty(message)) {
			if (items.isEmpty()) {
				mnv.addObject("message", "配送できる商品がありません");
			} else {
				mnv.addObject("message", "商品の検索が完了しました");
			}
		}

		Store store = storeService.findStore(Store.of(storeId));
		if (Objects.isNull(store)) {
			redirects.addFlashAttribute("message", "存在しない拠点コードです");
			mnv.setViewName("redirect:/transfer/stores");
			return mnv;
		}
		mnv.addObject("store", store);

		mnv.addObject("items", items);

		mnv.setViewName("transferItemSelect");
		return mnv;
	}

	@GetMapping("/store/{storeId}/item/{itemId}/deposit")
	public ModelAndView findTransferStore(
			ModelAndView mnv,
			@PathVariable("storeId") Long storeId,
			@PathVariable("itemId") Long itemId,
			@ModelAttribute("message") String message
		) {
		List<Store> relations = storeService.findStoreRelayed(Store.of(storeId));
		if (StringUtils.isEmpty(message)) {
			if (relations.isEmpty()) {
				mnv.addObject("message", "配送できる拠点がありません");
			} else {
				mnv.addObject("message", "配送できる拠点を表示しました");
			}
		}

		Store store = storeService.findStore(Store.of(storeId));
		mnv.addObject("store", store);

		Item item = itemService.findItem(Item.of(itemId));
		mnv.addObject("item", item);

		mnv.addObject("relations", relations);
		mnv.setViewName("transferStoreSelect");
		return mnv;
	}

	@PostMapping("/store/{storeId}/item/{itemId}/deposit/{transferStoreId}")
	public ModelAndView transferItem(
			ModelAndView mnv,
			@PathVariable("storeId") Long storeId,
			@PathVariable("itemId") Long itemId,
			@PathVariable("transferStoreId") Long transferStoreId,
			RedirectAttributes redirects
		) {

		itemService.transfer(Store.of(storeId), Item.of(itemId), Store.of(transferStoreId));
		mnv.addObject("message", "商品の配送が完了しました。");

		String redirectUrl = String.format("redirect:/transfer/store/%d/items", storeId);
		mnv.setViewName(redirectUrl);

		return mnv;
	}
}
