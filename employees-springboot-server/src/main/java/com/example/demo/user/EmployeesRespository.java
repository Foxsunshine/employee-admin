package com.example.demo.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeesRespository extends JpaRepository<Employees, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into employees(name,email,image) values(?1,?2,?3) ", nativeQuery = true)
    void createEmployee(String name, String email, String image);

    @Modifying
    @Transactional
    @Query(value = "insert into employees(image) values(?1) ", nativeQuery = true)
    void createEmployeeWithImg(String image);

    @Modifying
    @Transactional
    @Query(value = "update employees set name = ?1, email = ?2 where id = ?3", nativeQuery = true)
    int updateEmployeeById(String name, String email, int id);

    @Modifying
    @Transactional
    @Query(value = "delete from employees where id = ?1", nativeQuery = true)
    int deleteEmployeeById(int id);

}
