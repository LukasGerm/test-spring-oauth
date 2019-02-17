package eu.precode.TestApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),user.getAuthority());
    }
    public Page<User> getUsers(Pageable pageable){
        return repo.findAll(pageable);
    }

    public User create(User user){
        return repo.save(user);
    }
}
