package com.github.apz.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.github.apz.datasource.ItemMapper;
import com.github.apz.model.item.Item;
import com.github.apz.model.store.Store;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
	private final ItemMapper itemMapper;

	public List<Item> findStoreItems(Store store) {
		List<Item> result = itemMapper.findStoreItems(store);
		return result;
	}

	public void register(Item item) {
		itemMapper.register(item);
	}
}
