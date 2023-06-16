package com.example.demo.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("create")
    public String createName(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        String image = body.get("image");
        respository.createEmployee(name, email, image);
        return "successfully insert";
    }

    @PutMapping("update/{id}")
    public String updateById(@PathVariable int id, @RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        int rowsUpdated = respository.updateEmployeeById(name, email, id);
        return rowsUpdated + " row(s) have been updated";
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable int id) {
        int rowsUpdated = respository.deleteEmployeeById(id);
        return rowsUpdated + " row(s) have been deleted";
    }

}
