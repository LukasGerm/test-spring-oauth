package eu.precode.TestApp;


import lombok.Data;

import javax.persistence.Id;


import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
}

