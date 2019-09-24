package com.github.apz.model.item;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

	public static Item newItem(String name) {
		Item item = of(name);
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		item.setUpdateTime(now.toLocalDateTime());
		item.setInsertTime(now.toLocalDateTime());
		return item;
	}
}
