package com.github.apz.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.github.apz.annotation.DataModify;
import com.github.apz.model.item.Item;
import com.github.apz.model.item.ItemDeposit;
import com.github.apz.model.operation.OperationType;
import com.github.apz.model.store.Store;
import com.github.apz.service.operation.OperationRecorderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@RequiredArgsConstructor
@Log4j2
public class ServiceInterceptor {

	private final OperationRecorderService recordService;

	@After("execution(* com.github.apz.service.*.*Service.*(..)) && @annotation(annotation)")
    public void dataModifyBefore(JoinPoint joinpoint, DataModify annotation) {
		log.info("aop-before: {}" , joinpoint.getSignature());
		Object[] args = joinpoint.getArgs();

		OperationType operationType = annotation.value();

		if (operationType == OperationType.TRANSFER) {
			transfer(args);
			return;
		}

		Arrays.stream(args).forEach(arg -> {
			if (arg instanceof Item) {
				item((Item)arg, operationType);
			} else if (arg instanceof Store) {
				store((Store)arg, operationType);
			} else if (arg instanceof ItemDeposit) {
				deposit((ItemDeposit)arg);
			}
		});
    }

	private void item(Item item, OperationType operationType) {
		log.info("item : [{}] {} {}", operationType.name(), item.getItemId(), item.getName());

		recordService.item(item, operationType);
	}

	private void store(Store store, OperationType operationType) {
		log.info("store : [{}] {} {}", operationType.name(), store.getStoreId(), store.getStoreName());

		recordService.store(store, operationType);
	}

	private void deposit(ItemDeposit itemDeposit) {
		log.info("deposit : [{}] store {} , item {}", itemDeposit.isDeposit(), itemDeposit.getStoreId(), itemDeposit.getItemId());

		recordService.deposit(itemDeposit);
	}

	private void transfer(Object[] args) {
		Store store = (Store)args[0];
		Item item = (Item)args[1];
		Store transferStore = (Store)args[2];

		log.info("transfer : store {} -> {}, item {}" , store.getStoreId(), transferStore.getStoreId(), item.getItemId());

		recordService.transfer(store, item, transferStore);
	}
}
