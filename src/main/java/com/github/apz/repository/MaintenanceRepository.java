package com.github.apz.repository;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.MaintenanceMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MaintenanceRepository {

	final MaintenanceMapper mapper;

	public void deleteItemDeposit() {
		mapper.deleteItemDeposit();
	}

	public void deleteStoreRelation() {
		mapper.deleteStoreRelation();

	}

	public void deleteOperationLog() {
		mapper.deleteOperationLog();

	}

	public void deleteAllItem() {
		mapper.deleteAllItem();

	}

	public void deleteAllStore() {
		mapper.deleteAllStore();

	}

}
