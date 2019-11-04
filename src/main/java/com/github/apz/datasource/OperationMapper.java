package com.github.apz.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationLog;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;

@Mapper
public interface OperationMapper {
	public void recordItemOperation(Item item, OperationType type, String hashCode);

	public void recordStoreOperation(Store store, OperationType type, String hashCode);

	public void recordItemDeposit(Store store, Item item, OperationType type, String hashCode);

	public void recordItemTransfer(Store store, Item item, OperationType type, String hashCode);

	public List<OperationLog> find(Store store, Item item);
}
