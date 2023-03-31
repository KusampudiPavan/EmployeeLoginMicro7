package com.stl.EmployeeLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.EmployeeLogin.model.EmployeeLogin;

public interface EmployeeRepo extends JpaRepository<EmployeeLogin, String>{

}
