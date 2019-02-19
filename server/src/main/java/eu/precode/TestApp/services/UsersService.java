package eu.precode.TestApp.services;


import eu.precode.TestApp.models.User;
import eu.precode.TestApp.models.Role;
import eu.precode.TestApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UsersService implements UserDetailsService {

    @Autowired
    public PasswordEncoder encoder;

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

        Role role = new Role(user.getAdminLevel());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), role.getRole()) ;
    }
    public Page<User> getUsers(Pageable pageable){
        return repo.findAll(pageable);
    }

    public User create(User user){

        String encryptedPassword = this.encoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);
        return repo.save(user);
    }
}
