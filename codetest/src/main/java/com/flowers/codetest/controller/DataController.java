package com.flowers.codetest.controller;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flowers.codetest.constants.Constants;
import com.flowers.codetest.model.DataResponseVO;
import com.flowers.codetest.model.UniqueResponseVO;
import com.flowers.codetest.service.DataService;

@RestController
@ComponentScan(basePackages = "com.flowers.codetest.service")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	 /**Gets service raw data
	  * /v1/getData
	 * @return
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	@GetMapping(value=Constants.GET_DAT_REQUEST_MAPPING,  produces = Constants.PRODUCES_JSON)
	public Object getData() throws UnsupportedOperationException, IOException{
		 
		 return dataService.getData();
		
	}
	 /**
	  * Return unique data
	  * /v1/getData
	 * @return
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	@GetMapping(value=Constants.GET_UNIQUE_DAT_REQUEST_MAPPING,  produces = Constants.PRODUCES_JSON)
		public UniqueResponseVO getUniqueData() throws UnsupportedOperationException, IOException{
			 
			 return dataService.getUniqueData();
		}
	 
	 /**
	  * Modigies the data based on given Id 
	  * /v1/getData/modify/{id}
	 * @param id
	 * @return
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	@PutMapping(value=Constants.MODIFY_DAT_REQUEST_MAPPING,  produces = Constants.PRODUCES_JSON)
	 public Object updateData(  @PathVariable(Constants.ID) final int id) throws UnsupportedOperationException, IOException{
		 
		 return dataService.modifyData(id);
	}
 
	 

}
