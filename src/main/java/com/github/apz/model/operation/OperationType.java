package com.github.apz.model.operation;

import java.util.Arrays;

public enum OperationType {
	INSERT("追加"), UPDATE("更新"), DELETE("削除"), DEPOSIT("配置"), TRANSFER("");

	OperationType(String methodName) {
		this.methodName = methodName;
	}

	private String methodName;

	public String getMethodName() {
		return this.methodName;
	}

	public OperationType getOperationType(String methodName) {
		return Arrays.stream(values()).filter(elm -> elm.name().equals(methodName.toUpperCase())).findFirst().get();
	}
}
