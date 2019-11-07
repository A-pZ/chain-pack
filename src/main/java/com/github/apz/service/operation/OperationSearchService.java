package com.github.apz.service.operation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationLog;
import com.github.apz.model.store.Store;
import com.github.apz.repository.OperationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperationSearchService {
	final OperationRepository operationRepository;

	public List<OperationLog> findOperationLog() {
		return operationRepository.findOperationLog();
	}

	public List<OperationLog> finsStoreOperationLog(Store store, Item item) {
		return operationRepository.findOperationLog(store, item);
	}


	public List<OperationLog> findStoreOperationLog(Store store) {
		return operationRepository.findOperationLog(store);
	}

	public List<OperationLog> findStoreOperationLog(Item item) {
		return operationRepository.findOperationLog(item);
	}
}
