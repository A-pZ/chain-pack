package com.github.apz.model.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDeposit {
	private Long storeId;
	private Long itemId;
	private boolean deposit;

	ItemDeposit() {

	}

	public ItemDeposit (Long storeId, Long itemId, boolean deposit) {
		this.storeId = storeId;
		this.itemId = itemId;
		this.deposit = deposit;
	}

	public static ItemDeposit of(Long storeId, Long itemId, boolean deposit) {
		return new ItemDeposit(storeId, itemId, deposit);
	}
}
