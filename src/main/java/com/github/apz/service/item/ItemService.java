package com.github.apz.service.item;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.apz.model.item.Item;
import com.github.apz.model.store.Store;
import com.github.apz.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	final ItemRepository repository;

	public List<Item> findStoreItems(Store store) {
		return repository.findStoreItems(store);
	}

	public List<Item> findAllItems() {
		return repository.findStoreItems(Store.blank());
	}

	public void register(Item item) {
		repository.register(item);
	}

	public Item findItem(Item item) {
		return repository.findItem(item);
	}

	public void updateItem(Item item) {
		repository.updateItem(item);
	}
}
