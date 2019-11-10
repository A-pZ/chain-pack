package com.github.apz.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.github.apz.annotation.DataModify;
import com.github.apz.model.item.Item;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;
import com.github.apz.model.store.StoreRelation;

import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class RepositoryInterceptor {
	@Before("execution(* com.github.apz.repository.*Repository.*(..)) && @annotation(annotation)")
    public void dataModifyBefore(JoinPoint joinpoint, DataModify annotation) {
		log.info("aop-before: {}" , joinpoint.getSignature());
		OperationType operationType = annotation.value();
		Object[] args = joinpoint.getArgs();

		Arrays.stream(args).forEach(arg -> {
			if (arg instanceof Item) {
				item((Item)arg, operationType);
			} else if (arg instanceof Store) {
				store((Store)arg, operationType);
			} else if (arg instanceof StoreRelation) {
				storeRelation((StoreRelation)arg, operationType);
			}
		});
    }

	private void item(Item item, OperationType type) {
		log.info("item -> [{}] {} {}", type.name(), item.getItemId(), item.getName());
	}

	private void store(Store store, OperationType type) {
		log.info("store -> [{}] {} {}", type.name(), store.getStoreId(), store.getStoreName());

	}

	private void storeRelation(StoreRelation relation, OperationType type) {
		log.info("storeRelation -> [{}] {} {}", relation.getStoreId(), relation.getStoreName());
	}
}
