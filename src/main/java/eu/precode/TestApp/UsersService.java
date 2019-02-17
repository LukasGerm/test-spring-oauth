package eu.precode.TestApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UsersService implements UserDetailsService {

    public UserRepository repo;
    @Autowired
    public UsersService(UserRepository repo){
        this.repo = repo;
    }
    public UserDetails loadUserByUsername(String userId){
        User user = repo.getByUsername(userId);

        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        //Todo: Authority should be stored in database

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),user.getRoles());
    }
    public Page<User> getUsers(Pageable pageable){
        return repo.findAll(pageable);
    }

    public User create(User user){
        return repo.save(user);
    }
}
