package com.github.apz.service.operation;

import org.springframework.stereotype.Service;

import com.github.apz.repository.OperationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperationSearchService {
	final OperationRepository operationRepository;
}
