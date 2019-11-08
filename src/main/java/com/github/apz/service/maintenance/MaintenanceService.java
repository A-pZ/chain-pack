package com.github.apz.service.maintenance;

import org.springframework.stereotype.Service;

import com.github.apz.repository.MaintenanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaintenanceService {
	final MaintenanceRepository repository;

	public void deleteItemDeposit() {
		repository.deleteItemDeposit();
	}

	public void deleteStoreRelation() {
		repository.deleteStoreRelation();
	}

	public void deleteOperationLog() {
		repository.deleteOperationLog();
	}

	public void deleteAllItem() {
		repository.deleteAllItem();
		repository.deleteItemDeposit();
	}

	public void deleteAllStore() {
		repository.deleteAllStore();
		repository.deleteStoreRelation();
		repository.deleteItemDeposit();
	}
}
