package com.sunhuwh.springboot.springbootmongodb.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRespository extends MongoRepository<User, Long>{
	
	User findByUsername(String name);
	
}
