package com.github.apz.datasource;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.apz.model.item.Item;
import com.github.apz.model.store.Store;

@Mapper
public interface ItemMapper {

	public List<Item> findStoreItems(@Param("store") Store store);

	public void register(@Param("item") Item item);

	public Item findItem(@Param("item") Item item);

	public void updateItem(@Param("item") Item item);
}
