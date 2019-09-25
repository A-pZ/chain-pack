package com.github.apz.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.StoreMapper;
import com.github.apz.model.store.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepository {

	final StoreMapper mapper;

	public List<Store> findAllStore() {
		List<Store> result = mapper.findAllStore();
		return result.stream().map(item -> {
			item.setUpdateTime(item.getConvertedUpdateTime());
			item.setInsertTime(item.getConvertedInsertTime());
			return item;
		}).collect(Collectors.toList());
	}

	public void register(Store store) {
		mapper.register(store);
	}

	public void addStoreRelation(Store store, Store relationStore) {
		mapper.addStoreRelation(store, relationStore);
	}

	public List<Store> findStoreRelation(Store store) {
		return mapper.findStoreRelation(store);
	}

}
