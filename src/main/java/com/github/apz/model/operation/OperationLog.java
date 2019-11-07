package com.github.apz.model.operation;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OperationLog {
	private Long id;

	private OperationModel model;

	private Long itemId;

	private Long storeId;

	private OperationType type;

	private String hashCode;
}
