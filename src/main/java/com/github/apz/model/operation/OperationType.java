package com.github.apz.model.operation;

import java.util.Arrays;

public enum OperationType {
	INSERT, UPDATE, DELETE, DEPOSIT, TRANSFER;

	public OperationType getOperationType(String methodName) {
		return Arrays.stream(values()).filter(elm -> elm.name().equals(methodName.toUpperCase())).findFirst().get();
	}
}
