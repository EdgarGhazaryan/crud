package com.bdg.crud.controller;

import com.bdg.crud.model.User;
import com.bdg.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService userService;

    @PutMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PostMapping(path = "/{id}")
    public void update(@RequestBody User user, @PathVariable int id) {
        userService.update(user, id);
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping(path = "/{id}")
    public User deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }

    @DeleteMapping
    public User delete(@RequestBody User user) {
        return userService.delete(user);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll() {
        userService.deleteAll();
    }

}
