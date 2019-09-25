package com.github.apz.model.store;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.github.apz.model.ChainPackDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Store extends ChainPackDTO {
	private Long storeId;
	private String storeName;

	public static Store blank() {
		return new Store();
	}

	public static Store of(Long storeId) {
		Store store = new Store();
		store.setStoreId(storeId);
		return store;
	}

	public static Store of(String storeName) {
		Store store = new Store();
		store.setStoreName(storeName);
		return store;
	}

	public static Store newStore(String storeName) {
		Store store = of(storeName);
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		store.setUpdateTime(now.toLocalDateTime());
		store.setInsertTime(now.toLocalDateTime());
		return store;
	}
}
