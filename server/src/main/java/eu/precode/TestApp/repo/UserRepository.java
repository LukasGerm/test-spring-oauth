package eu.precode.TestApp.repo;

import eu.precode.TestApp.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    User getByUsername(String username);
}
