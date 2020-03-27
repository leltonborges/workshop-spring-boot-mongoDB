package com.workshop.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workshop.mongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
