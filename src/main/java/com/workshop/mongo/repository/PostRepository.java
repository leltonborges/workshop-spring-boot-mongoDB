package com.workshop.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.workshop.mongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//?0 -> é o primeiro paramento do methods
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
}
