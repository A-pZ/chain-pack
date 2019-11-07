package com.github.apz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationLog;
import com.github.apz.model.store.Store;
import com.github.apz.service.item.ItemService;
import com.github.apz.service.operation.OperationSearchService;
import com.github.apz.service.store.StoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/operation")
@RequiredArgsConstructor
public class OperationController {
	final OperationSearchService operationService;
	final StoreService storeService;
	final ItemService itemService;

	@GetMapping("/all")
	public ModelAndView findAll(ModelAndView mnv, RedirectAttributes redirects) {

		List<OperationLog> result = operationService.findOperationLog();

		List<Store> stores = storeService.findAllStore();
		stores.add(0, Store.blank());
		List<Item> items = itemService.findAllItems();
		items.add(0, Item.blank());

		mnv.addObject("operations", result);
		mnv.addObject("stores", stores);
		mnv.addObject("items", items);
		mnv.addObject("selectStore", Store.blank());
		mnv.addObject("selectItem", Item.blank());


		mnv.setViewName("operation");
		return mnv;
	}

	@GetMapping("/select")
	public ModelAndView find(ModelAndView mnv,
			@RequestParam("store") Long storeId,
			@RequestParam("item") Long itemId,
			RedirectAttributes redirects) {

		Store store = Store.of(storeId);
		Item item = Item.of(itemId);

		List<OperationLog> result = operationService.finsStoreOperationLog(store, item);
		List<Store> stores = storeService.findAllStore();
		stores.add(0, Store.blank());
		List<Item> items = itemService.findAllItems();
		items.add(0, Item.blank());

		mnv.addObject("operations", result);
		mnv.addObject("stores", stores);
		mnv.addObject("items", items);
		mnv.addObject("selectStore", store);
		mnv.addObject("selectItem", item);

		mnv.setViewName("operation");
		return mnv;
	}
}
