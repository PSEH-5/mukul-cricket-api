package com.cricket.api.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public interface ScoreService<T, U> {

	public T getData(U uniqueId, U authKey, Class<?> responseType) throws JsonProcessingException;

}
