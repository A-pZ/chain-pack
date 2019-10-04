package com.github.apz.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.apz.model.store.Store;
import com.github.apz.model.store.StoreRelation;

@Mapper
public interface StoreMapper {

	public List<Store> findAllStore();

	public void register(@Param("store") Store store);

	public List<StoreRelation> findStoreRelation(@Param("store") Store store);

	public Store findStore(@Param("store") Store store);

	public void updateStore(@Param("store") Store store);

	public void addStoreRelation(@Param("store") Store store, @Param("relation") Store relationStore);

	public void purgeStoreRelation(@Param("store") Store store, @Param("relation") Store relationStore);
}
