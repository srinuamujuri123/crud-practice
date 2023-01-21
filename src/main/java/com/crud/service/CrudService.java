package com.crud.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.CRUDDao;
import com.crud.model.BasicDetails;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CrudService {
	@Autowired
	CRUDDao crudDao;

	public List<String> getFruitsList() {

		return Arrays.asList("apple", "mango");
	}

	public List<String> getPhones() {

		return Arrays.asList("iphone", "samsung");
	}

	public BasicDetails getBasicDetails() {
		BasicDetails basicDetails = new BasicDetails();
		basicDetails.setName("sajid");
		basicDetails.setEmailId("shaik@email.com");
		return basicDetails;
	}

	public List<BasicDetails> getBasicDetailsList() {
		/*
		 * BasicDetails basicDetails = new BasicDetails("sajid","shaik@email.com");
		 * 
		 * BasicDetails basicDetails1 = new BasicDetails("shaik", "shaik@apple.com");
		 * 
		 * BasicDetails basicDetails2 = new BasicDetails("srinivas","shaik@email.com");
		 */

		/*
		 * List<BasicDetails> basicDetailsList = new ArrayList<>();
		 * basicDetailsList.add(new BasicDetails("sajid","shaik@email.com"));
		 * basicDetailsList.add(new BasicDetails("shaik", "shaik@apple.com"));
		 * basicDetailsList.add(new BasicDetails("srinivas","shaik@email.com"));
		 */

		/*
		 * List <BasicDetails> basicDetailsList = Arrays.asList(new
		 * BasicDetails("sajid","shaik@email.com"),new BasicDetails("shaik",
		 * "shaik@apple.com"),new BasicDetails("srinivas","shaik@email.com")); return
		 * basicDetailsList;
		 */
		return Arrays.asList(new BasicDetails("sajid", "sajid@email.com"), new BasicDetails("shaik", "shaik@apple.com"),
				new BasicDetails("srinivas", "srinivas@email.com"));
	}

	public List<BasicDetails> getBasicDetailsByEmailID(String emailId) {
		return getBasicDetailsList().stream().filter(e -> e.getEmailId().equals(emailId)).collect(Collectors.toList());
	}

	public String getNameByEmailID(String emailId) {
		List<BasicDetails> basicDetailsList = getBasicDetailsList();
		for (BasicDetails basicDetail : basicDetailsList) {
			if (basicDetail.getEmailId().equalsIgnoreCase(emailId)) {
				return basicDetail.getName();
			}
		}
		return "No data found";
	}

	public BasicDetails saveBasicDetails(BasicDetails basicDetails) {
		BasicDetails basicDetailsFRomDB = crudDao.save(basicDetails);
		return basicDetailsFRomDB;
	}

	public List<BasicDetails> getBasicDetailsFromDB() {
		return crudDao.findAll();
	}

	public Map<String, Object> getParticularBasicDetailsFromDB(Integer id) {
		Optional<BasicDetails> basicDetailsFromDB = crudDao.findById(id);

		Map data = new HashMap<>();
		if (basicDetailsFromDB.isPresent()) {
			data.put("email", basicDetailsFromDB.get().getEmailId()); 
			return data;
		}
		data.put("errormessage", "No data found");
		return data;
	}
}