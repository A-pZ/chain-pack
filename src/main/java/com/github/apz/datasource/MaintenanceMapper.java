package com.github.apz.datasource;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaintenanceMapper {
	public void deleteItemDeposit();

	public void deleteStoreRelation();

	public void deleteOperationLog();

	public void deleteAllItem();

	public void deleteAllStore();
}
