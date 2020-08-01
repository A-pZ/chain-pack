package com.github.apz.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.apz.datasource.ItemMapper;
import com.github.apz.model.item.Item;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemMapperTest {

	@Autowired
	ItemMapper itemMapper;

	@Test
	public void findAllItemsTest() {
		List<Item> items = itemMapper.findAllItems();

		assertThat(items.size()).isEqualTo(22);
	}
}
