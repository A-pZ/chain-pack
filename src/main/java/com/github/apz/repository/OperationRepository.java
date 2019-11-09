package com.github.apz.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.OperationMapper;
import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationLog;
import com.github.apz.model.operation.OperationLogHash;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OperationRepository {

	private final OperationMapper mapper;
	private final OperationLogHash logModel;

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

	public void transfer(Store store, Item item, OperationType operationType) {
		String hashCode = logModel.hash(store, item, operationType.name());

		mapper.recordItemTransfer(store, item, operationType, hashCode);
	}

	public List<OperationLog> findOperationLog() {
		return mapper.find(null, null);
	}

	public List<OperationLog> findOperationLog(Store store) {
		return mapper.find(store, null);
	}

	public List<OperationLog> findOperationLog(Item item) {
		return mapper.find(null, item);
	}

	public List<OperationLog> findOperationLog(Store store, Item item) {
		return mapper.find(store, item);
	}

	public Long lastInsertId() {
		return mapper.lastInsertId();
	}
}
