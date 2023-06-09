package com.example.demo.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeesRespository extends JpaRepository<Employees, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into employees(name,email) values(?1,?2) ", nativeQuery = true)
    void createEmployee(String name, String email);

    @Modifying
    @Transactional
    @Query(value = "update employees set name = ?1, email = ?2 where id = ?3", nativeQuery = true)
    int updateEmployeesById(String name, String email, int id);

}
