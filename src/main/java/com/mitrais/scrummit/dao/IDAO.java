package com.mitrais.scrummit.dao;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IDAO <T, ID extends Serializable> extends MongoRepository<T, ID> {
    List<T> findByModifiedBy(ObjectId id);

    List<T> findByCreatedBy(ObjectId id);

}
