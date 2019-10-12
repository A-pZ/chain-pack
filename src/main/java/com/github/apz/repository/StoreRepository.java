package com.github.apz.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.StoreMapper;
import com.github.apz.model.store.Store;
import com.github.apz.model.store.StoreRelation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepository {

	final StoreMapper mapper;

	public List<Store> findAllStore() {
		List<Store> result = mapper.findAllStore();
		return result;
	}

	public void register(Store store) {
		mapper.register(store);
	}

	public List<StoreRelation> findStoreRelation(Store store) {
		return mapper.findStoreRelation(store);
	}

	public void addStoreRelation(Store store, Store relationStore) {
		mapper.addStoreRelation(store, relationStore);
	}

	public void purgeStoreRelation(Store store, Store relationStore) {
		mapper.purgeStoreRelation(store, relationStore);
	}

	public Store findStore(Store store) {
		return mapper.findStore(store);
	}

	public void updateStore(Store store) {
		mapper.updateStore(store);
	}

	public List<Store> findStoreRelayed(Store store) {
		return mapper.findStoreRelayed(store);
	}
}
