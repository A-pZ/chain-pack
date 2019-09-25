package com.github.apz.service.store;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.apz.model.store.Store;
import com.github.apz.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {

	final StoreRepository repository;

	public List<Store> findAllStore() {
		List<Store> stores = repository.findAllStore();

		return stores;
	}

	public void register(Store store) {
		repository.register(store);
	}
	
	public List<Store> findStoreRelation(Store store) {
		List<Store> relation = repository.findStoreRelation(store);
		return relation;
	}
	
	public void addStoreRelation(Store store, Store relationStore) {
		repository.addStoreRelation(store, relationStore);
	}


}
