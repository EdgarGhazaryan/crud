package com.bdg.crud.service;

import com.bdg.crud.model.User;
import com.bdg.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Iterable<User> all = userRepository.findAll();
        for(User user : all) {
            list.add(user);
        }
        return list;
    }

    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }

    public long count() {
        return userRepository.count();
    }

    public User deleteById(int id) {
        User user = getById(id);
        if(user != null) {
            userRepository.deleteById(id);
        }
        return user;
    }

    public User delete(User user) {
        if(user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}
