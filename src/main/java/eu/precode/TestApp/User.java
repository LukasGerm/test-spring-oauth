package eu.precode.TestApp;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Id;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Range(max = 4294967295L)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authority;
}

