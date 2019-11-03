package com.github.apz.service.operation;

import org.springframework.stereotype.Service;

import com.github.apz.model.item.Item;
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

	public void deposit(Store store, Item item, Store transferStore) {
		repository.deposit(store, item, OperationType.DELETE);

		repository.deposit(transferStore, item, OperationType.INSERT);
	}
}
