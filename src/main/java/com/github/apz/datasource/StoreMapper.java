package com.github.apz.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.apz.model.store.Store;

@Mapper
public interface StoreMapper {

	public List<Store> findAllStore();

	public void register(@Param("store") Store store);

	public List<Store> findStoreRelation(@Param("store") Store store);

	public void addStoreRelation(@Param("store") Store store, @Param("relation") Store relationStore);

	public void purgeStoreRelation(@Param("store") Store store, @Param("relation") Store relationStore);

}
