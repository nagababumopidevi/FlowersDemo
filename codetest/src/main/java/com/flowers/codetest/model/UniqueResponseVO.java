package com.flowers.codetest.model;

import java.util.Set;

public class UniqueResponseVO {
	
	private int uniqueDataCount;
	private Set<DataResponseVO> uniqueData;
	public int getUniqueDataCount() {
		return uniqueDataCount;
	}
	public void setUniqueDataCount(int uniqueDataCount) {
		this.uniqueDataCount = uniqueDataCount;
	}
	public Set<DataResponseVO> getUniqueData() {
		return uniqueData;
	}
	public void setUniqueData(Set<DataResponseVO> uniqueData) {
		this.uniqueData = uniqueData;
	}
	
	
	

}
