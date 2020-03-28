package com.workshop.mongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.mongo.domain.Post;
import com.workshop.mongo.repository.PostRepository;
import com.workshop.mongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> p = repository.findById(id);
		return p.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
	}
	
//	public List<Post> findByTitle(String text){
//		return repository.findByTitleContainingIgnoreCase(text);
//	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
