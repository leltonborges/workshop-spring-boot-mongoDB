package com.workshop.mongo.service;

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
}
