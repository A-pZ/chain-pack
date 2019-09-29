package com.github.apz.service.store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.apz.model.store.Store;
import com.github.apz.model.store.StoreRelation;
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

	public List<StoreRelation> findStoreRelation(Store store) {
		List<StoreRelation> relations = repository.findStoreRelation(store);

		List<Store> stores = repository.findAllStore();

		List<StoreRelation> result = storeRelationFlagged(store, stores, relations);

		return result;
	}

	public void addStoreRelation(Store store, Store relationStore) {
		repository.addStoreRelation(store, relationStore);
	}

	public void purgeStoreRelation(Store store, Store relationStore) {
		repository.purgeStoreRelation(store, relationStore);
	}

	private List<StoreRelation> storeRelationFlagged(Store target, List<Store> stores, List<StoreRelation> relations) {
		List<StoreRelation> result = new ArrayList<>();

		List<Long> relationNumbers = relations.stream()
				.map(relation -> relation.getRelationStoreId())
				.collect(Collectors.toList());

		for(Store store: stores) {
			Long storeId = store.getStoreId();
			if (storeId.longValue() == target.getStoreId()) continue;

			StoreRelation storeRelation = StoreRelation.of(target.getStoreId(), store.getStoreId(), store.getStoreName(), relationNumbers.contains(storeId));
			result.add(storeRelation);
		}

		return result;
	}

	public Store findStore(Store store) {
		return repository.findStore(store);
	}

	public void updateStoreName(Store store) {
		repository.updateStore(store);
	}
}
