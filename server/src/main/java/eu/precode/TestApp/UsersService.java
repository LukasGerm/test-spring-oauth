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
        //Create a new list
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        //Because the roles are stored as a concatenated string, they should get split by ",".
        String[] roleParts = user.getRoles().split(",");
        //For every found role, it gets add to the list
        for(String role : roleParts){
            roles.add(new SimpleGrantedAuthority(role));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),roles);
    }
    public Page<User> getUsers(Pageable pageable){
        return repo.findAll(pageable);
    }

    public User create(User user){
        return repo.save(user);
    }
}
