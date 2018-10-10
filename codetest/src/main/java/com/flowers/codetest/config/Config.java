package com.flowers.codetest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	 @Value("${serviceUrl}")
	private String serviceUrl;
	 
	 @Value("${proxyIp}")
	private String proxyIp;
	 
	 @Value("${proxyPort}")
	private int proxyPort;
	 
	 @Value("${newTitle}")
	private String newTitle;
	 
	 @Value("${newBody}")
	private String newBody;
	 
	 @Value("${proxyEnabled}")
	 private Boolean proxyEnabled;
	 
	 

	public Boolean getProxyEnabled() {
		return proxyEnabled;
	}

	public void setProxyEnabled(Boolean proxyEnabled) {
		this.proxyEnabled = proxyEnabled;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getProxyIp() {
		return proxyIp;
	}

	public void setProxyIp(String proxyIp) {
		this.proxyIp = proxyIp;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewBody() {
		return newBody;
	}

	public void setNewBody(String newBody) {
		this.newBody = newBody;
	}
	 
	 
	

}
