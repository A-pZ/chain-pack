package com.github.apz.service.item;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.apz.model.item.Item;
import com.github.apz.model.item.ItemDeposit;
import com.github.apz.model.item.ItemStoreDeposit;
import com.github.apz.model.store.Store;
import com.github.apz.repository.ItemRepository;
import com.github.apz.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	final ItemRepository repository;
	final StoreRepository storeRepository;

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

	public List<ItemStoreDeposit> findDeposit(Item item) {
		List<ItemDeposit> depositedList = repository.findDeposit(item);
		List<Store> stores = storeRepository.findAllStore();

		List<ItemStoreDeposit> result = stores.stream().map(store -> {
			Optional<ItemDeposit> deposit = depositedList.stream()
					.filter(depositOne -> depositOne.getItemId() == store.getStoreId())
					.findAny();
			return ItemStoreDeposit.of(item, store, deposit.isPresent());
		}).collect(Collectors.toList());

		return result;
	}
}
