package com.flowers.codetest.dataaccess;


import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.flowers.codetest.config.Config;
import com.flowers.codetest.model.DataResponseVO;

@Component
@ComponentScan(basePackages = "com.flowers.codetest.config")
public class DataAccessImpl implements DataAccess {
	
	
	@Autowired
	private Config config;
	
	
	@Override
	public DataResponseVO[] getData() throws UnsupportedOperationException, IOException {
		
		 SimpleClientHttpRequestFactory requestFactory = null;
		
		 final String uri = config.getServiceUrl();
		 RestTemplate restTemplate = new RestTemplate();
		 requestFactory = (SimpleClientHttpRequestFactory)restTemplate.getRequestFactory();
		 if (config.getProxyEnabled()){
			 Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(
	                    config.getProxyIp(),config.getProxyPort())); 
			 requestFactory.setProxy(proxy);
		 }
	        ResponseEntity<DataResponseVO[]> exchange = restTemplate.exchange(uri, HttpMethod.GET, null, DataResponseVO[].class);
	       
		    
		return exchange.getBody();
	}

}
