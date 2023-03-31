package com.stl.EmployeeLogin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stl.EmployeeLogin.model.EmployeeLogin;
import com.stl.EmployeeLogin.repository.EmployeeRepo;

@Service
public class EmployeelogService implements UserDetailsService{
    @Autowired
    EmployeeRepo employeerepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        EmployeeLogin employee = employeerepo.findById(username).get();
        if(employee == null) {
            return null;
        }
        
        return new Employeelog(employee);
    }
    
}
