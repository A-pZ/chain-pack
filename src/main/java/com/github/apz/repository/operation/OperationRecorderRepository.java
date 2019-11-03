package com.github.apz.repository.operation;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.OperationMapper;
import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OperationRecorderRepository {

	private final OperationMapper mapper;

	public void item(Item item, OperationType operationType) {
		mapper.recordItemOperation(item, operationType);
	}

	public void store(Store store, OperationType operationType) {
		mapper.recordStoreOperation(store, operationType);
	}

	public void deposit(Store store, Item item, OperationType operationType) {
		mapper.recordItemDeposit(store, item, operationType);
	}
}
