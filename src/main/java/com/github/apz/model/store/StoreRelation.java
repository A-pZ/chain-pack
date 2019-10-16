package com.github.apz.model.store;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StoreRelation {
	private Long storeId;
	private Long relationStoreId;
	private String storeName;
	private boolean relation;

	StoreRelation() {
		// NOP
	}

	StoreRelation(Long storeId, Long relationStoreId, String storeName, boolean relation) {
		this.storeId = storeId;
		this.relationStoreId = relationStoreId;
		this.storeName = storeName;
		this.relation = relation;
	}

	public static StoreRelation of(Long storeId, Long relationStoreId, String storeName, boolean relation) {
		return new StoreRelation(storeId, relationStoreId, storeName, relation);
	}

	public static StoreRelation relation(Long storeId, Long relationStoreId, boolean relation) {
		return new StoreRelation(storeId, relationStoreId, null, relation);
	}

}
