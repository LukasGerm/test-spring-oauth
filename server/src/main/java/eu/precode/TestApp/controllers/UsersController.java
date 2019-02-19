package eu.precode.TestApp.controllers;

import eu.precode.TestApp.services.UsersService;
import eu.precode.TestApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
public class UsersController {
    @Autowired
    UsersService service;

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return service.getUsers(pageable);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PostMapping("/addTestUser")
    public User addTestUser(@RequestBody User user){
        return service.create(user);
    }

}
