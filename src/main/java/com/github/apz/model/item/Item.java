package com.github.apz.model.item;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.github.apz.model.ChainPackDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item extends ChainPackDTO {
	private Long itemId;
	private String name;

	public static Item of(String name) {
		Item item = new Item();
		item.setName(name);
		return item;
	}

	public static Item of(Long itemId) {
		Item item = new Item();
		item.setItemId(itemId);
		return item;
	}

	public static Item blank() {
		return new Item();
	}

	public boolean exist() {
		return itemId != null;
	}

	public static Item newItem(String name) {
		Item item = of(name);
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		item.setUpdateTime(now.toLocalDateTime());
		item.setInsertTime(now.toLocalDateTime());
		return item;
	}

	public static Item updateItem(Long itemId, String name) {
		Item item = new Item();
		item.setItemId(itemId);
		item.setName(name);
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		item.setUpdateTime(now.toLocalDateTime());
		return item;
	}
}
