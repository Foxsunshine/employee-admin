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
    @Query(value = "update employees set name = ?1, email = ?2,image = ?3 where id = ?4", nativeQuery = true)
    void updateEmployeeById(String name, String email, String image, int id);

}
