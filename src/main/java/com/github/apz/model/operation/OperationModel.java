package com.github.apz.model.operation;

import java.util.Arrays;

public enum OperationModel {
	ITEM("商品"), STORE("拠点"), DEPOSIT("配置"), TRANSFER("配送");

	OperationModel(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public OperationModel getOperationModel(String name) {
		return Arrays.stream(values()).filter(elm -> elm.name().equals(name.toUpperCase())).findFirst().get();
	}
}
