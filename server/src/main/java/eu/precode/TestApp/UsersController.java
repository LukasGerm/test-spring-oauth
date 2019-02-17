package eu.precode.TestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
public class UsersController {
    UsersService service;

    @Autowired
    UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return service.getUsers(pageable);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

}
