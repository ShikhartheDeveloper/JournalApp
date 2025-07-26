package com.shikhar.JournalApp.repository;

import com.shikhar.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User , ObjectId> {

    User findByUserName(String username);

}
