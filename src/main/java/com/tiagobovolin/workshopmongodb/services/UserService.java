package com.tiagobovolin.workshopmongodb.services;

import com.tiagobovolin.workshopmongodb.domain.User;
import com.tiagobovolin.workshopmongodb.repository.UserRepository;
import com.tiagobovolin.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }
}
