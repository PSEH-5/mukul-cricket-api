package com.cricket.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cricket.api.entity.ScoreEntity;
import com.cricket.api.service.ScoreService;
import com.cricket.api.util.ApiName;
import com.cricket.api.util.MapperUtil;
import com.cricket.api.util.RestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ScoreServiceImpl implements ScoreService<Object, String> {

	private static final String UNIQUEID = "unique_id";
	private static final String AUTHERIZATION = "apikey";

	@Autowired
	RestClient restClient;
	
	@Autowired
	MapperUtil util;
	
	@Override
	public Object getData(String uniqueId, String authKey, Class<?> responseType) throws JsonProcessingException {
		String paramName[] = {UNIQUEID, AUTHERIZATION};
		String paramVal[] = {uniqueId, authKey};
		String x = (String) restClient.getApi(ApiName.CricketScore, paramName, paramVal, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			ScoreEntity scoreEntity = (ScoreEntity) mapper.readValue(x, ScoreEntity.class);
			return util.mapData(scoreEntity);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw e;
		}
	}
	

}
