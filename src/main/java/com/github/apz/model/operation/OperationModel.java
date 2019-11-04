package com.github.apz.model.operation;

import java.util.Arrays;

public enum OperationModel {
	ITEM, STORE, DEPOSIT, TRANSFER;

	public OperationModel getOperationModel(String name) {
		return Arrays.stream(values()).filter(elm -> elm.name().equals(name.toUpperCase())).findFirst().get();
	}
}
