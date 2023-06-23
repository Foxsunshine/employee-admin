package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
    private EmployeesRespository respository;

    @GetMapping("/employees")
    public List<Employees> getAllEmployees() {
        List<Employees> employees = respository.findAll();
        return employees;
    }

    @GetMapping("/employees/details")
    public Page<Employees> getEmployees(@RequestParam(defaultValue = "0") int page) {
        return respository.findAll(PageRequest.of(page, 10));
    }

    @GetMapping("/employees/{id}")
    public Optional<Employees> getEmployeeById(@PathVariable int id) {
        Optional<Employees> employee = respository.findById(id);
        return employee;
    }

    @PostMapping("create")
    public String createName(@RequestBody Employees employee) {
        respository.save(employee);
        return "successfully insert";
    }

    @PutMapping("update/{id}")
    public String updateById(@PathVariable int id, @RequestBody Employees employee) {
        respository.updateEmployeeById(employee.getName(), employee.getEmail(), employee.getImage(), id);
        return id + " successfully update";
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable int id) {
        respository.deleteById(id);
        return id + " have been deleted";
    }

}
