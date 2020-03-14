package com.cricket.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestClient {

	@Autowired
	Environment env;

	public Object getApi(ApiName api, String[] queryParamName, String[] queryParamValue, Class<?> responseType) {
		RestTemplate restTemplate;
		String apiHostIpPort = env.getProperty(api.name());
		UriComponentsBuilder builder = null;
		UriComponents uriComponents = null;
		builder = UriComponentsBuilder.fromUriString(apiHostIpPort);
		if (apiHostIpPort != null) {
			if (queryParamName.length != 0) {
				for (int i = 0; i < queryParamName.length; i++) {
					builder.queryParam(queryParamName[i], queryParamValue[i]);
				}
			}
			uriComponents = builder.build(false).encode();
		}
		try {
			restTemplate = new RestTemplate();
			return restTemplate.getForObject(uriComponents.toUri(), responseType);
		} catch (Exception e) {
			throw e;
		}

	}
}
