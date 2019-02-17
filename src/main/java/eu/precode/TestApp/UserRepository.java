package eu.precode.TestApp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    User getByUsername(String username);
}
