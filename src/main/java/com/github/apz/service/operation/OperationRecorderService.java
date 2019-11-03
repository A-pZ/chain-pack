package com.github.apz.service.operation;

import org.springframework.stereotype.Service;

import com.github.apz.model.item.Item;
import com.github.apz.model.item.ItemDeposit;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;
import com.github.apz.repository.operation.OperationRecorderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperationRecorderService {

	final OperationRecorderRepository repository;

	public void item(Item item, OperationType operationType) {
		repository.item(item, operationType);
	}

	public void store(Store store, OperationType operationType) {
		repository.store(store, operationType);
	}

	public void deposit(ItemDeposit itemDeposit) {
		Store store = Store.of(itemDeposit.getStoreId());
		Item item = Item.of(itemDeposit.getItemId());
		OperationType operationType = itemDeposit.isDeposit() ? OperationType.INSERT : OperationType.DELETE;

		repository.deposit(store, item, operationType);
	}

	public void transfer(Store store, Item item, Store transferStore) {
		repository.transfer(store, item, OperationType.DELETE);

		repository.transfer(transferStore, item, OperationType.INSERT);
	}
}
