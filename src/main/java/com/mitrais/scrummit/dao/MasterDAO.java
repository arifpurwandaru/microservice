package com.mitrais.scrummit.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class MasterDAO<T, ID extends Serializable> {
	
	@Autowired
    protected MongoTemplate mongoTemplate;

}
