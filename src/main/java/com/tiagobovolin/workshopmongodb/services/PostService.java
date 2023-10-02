package com.tiagobovolin.workshopmongodb.services;

import com.tiagobovolin.workshopmongodb.domain.Post;
import com.tiagobovolin.workshopmongodb.repository.PostRepository;
import com.tiagobovolin.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }
}
