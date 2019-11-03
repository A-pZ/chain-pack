package com.github.apz.repository.operation;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.OperationMapper;
import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationLog;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OperationRecorderRepository {

	private final OperationMapper mapper;
	private final OperationLog logModel;

	public void item(Item item, OperationType operationType) {
		String hashCode = logModel.hash(item, operationType.name());

		mapper.recordItemOperation(item, operationType, hashCode);
	}

	public void store(Store store, OperationType operationType) {
		String hashCode = logModel.hash(store, operationType.name());

		mapper.recordStoreOperation(store, operationType, hashCode);
	}

	public void deposit(Store store, Item item, OperationType operationType) {
		String hashCode = logModel.hash(store, item, operationType.name());

		mapper.recordItemDeposit(store, item, operationType, hashCode);
	}
}
