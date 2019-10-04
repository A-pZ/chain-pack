package com.github.apz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.apz.model.store.Store;
import com.github.apz.service.store.StoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("store")
@RequiredArgsConstructor
public class StoreRelationController {
	final StoreService service;

	@PostMapping("/{storeId}/relation/{relationStoreId}")
	public String updateStoreRelationStatus(
			ModelAndView mnv,
			@PathVariable("storeId") Long storeId,
			@PathVariable("relationStoreId") Long relationStoreId,
			@RequestParam("relation") boolean relation,
			RedirectAttributes redirects) {

		service.updateStoreRelation(Store.of(storeId), Store.of(relationStoreId), relation);

		return "success";
	}
}
