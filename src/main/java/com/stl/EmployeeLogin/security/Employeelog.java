package com.stl.EmployeeLogin.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.stl.EmployeeLogin.model.EmployeeLogin;

@SuppressWarnings("serial")
public class Employeelog implements UserDetails{
    EmployeeLogin employee = new EmployeeLogin();
    
    public Employeelog(EmployeeLogin employee){
        this.employee=employee;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("MANAGER"));
    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    

    @Override
    public String getUsername() {
        return employee.getEmail();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
