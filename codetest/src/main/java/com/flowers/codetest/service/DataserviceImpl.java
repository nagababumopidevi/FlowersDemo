package com.flowers.codetest.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.flowers.codetest.config.Config;
import com.flowers.codetest.dataaccess.DataAccess;
import com.flowers.codetest.model.DataResponseVO;
import com.flowers.codetest.model.UniqueResponseVO;

@Service
@ComponentScan(basePackages = {"com.flowers.codetest.dataaccess","com.flowers.codetest.config"})
public class DataserviceImpl implements DataService {

	@Autowired
	private DataAccess dataaccess;
	
	@Autowired
	private Config config;

	@Override
	public Object getData() throws UnsupportedOperationException, IOException {
		return dataaccess.getData();
	}

	@Override
	public UniqueResponseVO getUniqueData() throws UnsupportedOperationException, IOException {
		DataResponseVO[] responseDataArray = (DataResponseVO[]) dataaccess.getData();
		List<DataResponseVO> asList = Arrays.asList(responseDataArray);
		
		Set<DataResponseVO> s = new HashSet<>(asList);
		UniqueResponseVO response = new UniqueResponseVO();
		response.setUniqueData(s);
		response.setUniqueDataCount(s.size());
		return response;
	}

	@Override
	public Object modifyData(int id) throws UnsupportedOperationException, IOException {
		DataResponseVO[] responseDataArray = (DataResponseVO[]) dataaccess.getData();
		List<DataResponseVO> asList = Arrays.asList(responseDataArray);
		DataResponseVO result  = null;
		if (!CollectionUtils.isEmpty(asList)){
			Optional<DataResponseVO> matchedData = asList.stream().filter(Objects::nonNull).filter(vo-> vo.getId()==id).findAny();
			if (matchedData.isPresent()){
				result = matchedData.get();
			}
			if (result!= null){
				result.setTitle(config.getNewTitle());
				result.setBody(config.getNewBody());
				return result;
			}
		}
		
		return null;
	}

}
