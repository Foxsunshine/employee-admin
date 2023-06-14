package com.luv2code.springboot.cruddemo.entity;

import java.util.Arrays;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "image")
    private byte[] imgae;

    // define constructors

    public Employee() {

    }

    public Employee(String name, String email, byte[] imgae) {

        this.name = name;
        this.email = email;
        this.imgae = imgae;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getImgae() {
        return imgae;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImgae(byte[] imgae) {
        this.imgae = imgae;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", imgae=" + Arrays.toString(imgae) + "]";
    }

}
