/*
package com.crud.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

	@GetMapping("/health")
	public String healthCheck() {

		return "working fine";
	}
	@GetMapping("/fruitsList")
	public List<String> getfruits(){
		return Arrays.asList("apples", "banana","jackfruit");
	}
}

*/

package com.crud.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.BasicDetails;
import com.crud.service.CrudService;

@RestController
public class CrudController {

	@Autowired
	CrudService crudService;

	@GetMapping("/health")
	public String healthCheck() {

		return "working fine";
	}

	@GetMapping("/list")
	public List<String> getList() {

		return crudService.getFruitsList();
	}

	@GetMapping("/listPhones")
	public List<String> getPhones() {

		return crudService.getPhones();
	}

	@GetMapping("/getBasicDetails")
	public BasicDetails getBasicDetails() {

		return crudService.getBasicDetails();
	}

	@GetMapping("/getBasicDetailsList")
	public List<BasicDetails> getBasicDetailsList() {

		return crudService.getBasicDetailsList();
	}

	@GetMapping("/getBasicDetailsByEmailID")
	public List<BasicDetails> getBasicDetailsByID(@RequestParam String emailId) {

		return crudService.getBasicDetailsByEmailID(emailId);
	}

	@GetMapping("/getNameByEmailID")
	public String getNameByEmailID(@RequestParam String emailId) {

		return crudService.getNameByEmailID(emailId);
	}

	// @PathVariable
	@GetMapping("/getNameByEmailId/{emailId}")
	public String getNameByEmailIdUsingVariable(@PathVariable String emailId) {

		return crudService.getNameByEmailID(emailId);
	}

	@PostMapping("/save")
	public BasicDetails saveBasicDetails(@RequestBody BasicDetails basicDetails) {

		return crudService.saveBasicDetails(basicDetails);
	}

	@GetMapping("/getBasicDetailsFromDB")
	public List<BasicDetails> getBasicDetailsFromDB() {

		return crudService.getBasicDetailsFromDB();
	}

	@GetMapping("/getParticularBasicDetailsFromDB")
	public Map<String, Object> getParticularBasicDetailsFromDB(@RequestParam Integer id) {

		return crudService.getParticularBasicDetailsFromDB(id);
	}

}
