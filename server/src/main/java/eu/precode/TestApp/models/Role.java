package eu.precode.TestApp.models;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

//class for defining the adminlevel
public class Role {
    private String[] roles = {"ROLE_USER", "ROLE_ADMIN"};
    private int adminLevel;
    public Role(int adminLevel){
        this.adminLevel = adminLevel;
    }

    public List<SimpleGrantedAuthority> getRole(){
        List<SimpleGrantedAuthority> roles = new ArrayList();
        roles.add(new SimpleGrantedAuthority(this.roles[adminLevel]));
        return roles;
    }
}
