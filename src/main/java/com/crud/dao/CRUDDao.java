
package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.BasicDetails;

public interface CRUDDao extends JpaRepository<BasicDetails, Integer> {

	
}
