package com.github.apz.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.github.apz.datasource.ItemMapper;
import com.github.apz.model.item.Item;
import com.github.apz.model.item.ItemDeposit;
import com.github.apz.model.store.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
	private final ItemMapper itemMapper;

	public List<Item> findStoreItems(Store store) {
		return itemMapper.findStoreItems(store);
	}

	public void register(Item item) {
		itemMapper.register(item);
	}

	public Item findItem(Item item) {
		return itemMapper.findItem(item);
	}

	public void updateItem(Item item) {
		itemMapper.updateItem(item);
	}

	public List<ItemDeposit> findDeposit(Item item) {
		return itemMapper.findDeposit(item);
	}

	public void addItemDeposit(ItemDeposit itemDeposit) {
		itemMapper.addItemDeposit(itemDeposit);
	}

	public void purgeItemDeposit(ItemDeposit itemDeposit) {
		itemMapper.purgeItemDeposit(itemDeposit);
	}
}
