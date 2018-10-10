package com.flowers.codetest.service;

import java.io.IOException;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.flowers.codetest.model.DataResponseVO;
import com.flowers.codetest.model.UniqueResponseVO;


public interface DataService {
	Object getData() throws UnsupportedOperationException, IOException;

	UniqueResponseVO getUniqueData() throws UnsupportedOperationException, IOException;

	Object modifyData(int id) throws UnsupportedOperationException, IOException;

}
