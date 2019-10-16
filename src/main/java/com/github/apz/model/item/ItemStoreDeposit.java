package com.github.apz.model.item;

import com.github.apz.model.store.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ItemStoreDeposit {
	private Item item;
	private Store store;
	private boolean deposit;

	public static ItemStoreDeposit of(Item item, Store store, boolean deposit) {
		return new ItemStoreDeposit(item, store, deposit);
	}
}
