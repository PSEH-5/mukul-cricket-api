package com.cricket.api.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.api.entity.ScoreEntity;
import com.cricket.api.service.ScoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/cricketScore")
public class CricketScoreController {
	
	@Autowired
	ScoreService<Object, String> scoreService;
	

	@GetMapping(value = "/")
	public ResponseEntity<Object> getAll(@RequestParam("uniqueId") String uniqueId,
			@RequestParam("authorization") String authKey) throws JsonProcessingException {
		return ResponseEntity.status(HttpStatus.OK).body(scoreService.getData(uniqueId, authKey, ScoreEntity.class));
	}
	
	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "ckey", groupKey = "gKey")
	@GetMapping(value = "/getB")
	public String get() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	public String fallBack() {
		return "doone";
	}
}
