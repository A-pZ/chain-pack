package com.github.apz.service.item;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.apz.annotation.DataModify;
import com.github.apz.model.item.Item;
import com.github.apz.model.item.ItemDeposit;
import com.github.apz.model.item.ItemStoreDeposit;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;
import com.github.apz.repository.ItemRepository;
import com.github.apz.repository.StoreRepository;
import com.github.apz.service.operation.OperationRecorderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
	final ItemRepository repository;
	final StoreRepository storeRepository;
	final OperationRecorderService recordService;

	public List<Item> findAllItems() {
		return repository.findAllItems();
	}

	public List<Item> findStoreItems(Store store) {
		return repository.findStoreItems(store);
	}

	@DataModify(OperationType.INSERT)
	public void register(Item item) {
		repository.register(item);

		Long id = recordService.lastInsertId();
		item.setItemId(id);
	}

	public Item findItem(Item item) {
		return repository.findItem(item);
	}

	@DataModify(OperationType.UPDATE)
	public void updateItem(Item item) {
		repository.updateItem(item);
	}

	public List<ItemStoreDeposit> findDeposit(Item item) {
		List<ItemDeposit> depositedList = repository.findDeposit(item);
		List<Store> stores = storeRepository.findAllStore();

		List<ItemStoreDeposit> result = stores.stream().map(store -> {
			Optional<ItemDeposit> deposit = depositedList.stream()
					.filter(depositOne -> depositOne.getStoreId() == store.getStoreId())
					.findAny();
			return ItemStoreDeposit.of(item, store, deposit.isPresent());
		}).collect(Collectors.toList());

		return result;
	}

	@DataModify(OperationType.DEPOSIT)
	public void updateItemDeposit(ItemDeposit itemDeposit) {
		if (itemDeposit.isDeposit()) {
			repository.addItemDeposit(itemDeposit);
		} else {
			repository.purgeItemDeposit(itemDeposit);
		}
	}

	@DataModify(OperationType.TRANSFER)
	public void transfer(Store store, Item item, Store transferStore) {
		repository.addItemDeposit(ItemDeposit.of(transferStore.getStoreId(), item.getItemId(), true));

		repository.purgeItemDeposit(ItemDeposit.of(store.getStoreId(), item.getItemId(), true));
	}
}
