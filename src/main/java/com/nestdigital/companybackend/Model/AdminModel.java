package com.nestdigital.companybackend.Model;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class AdminModel {
    @Id
    @GeneratedValue

    private int id;
    private int emp_code;
    private String name;
    private String dob;
    private String phone;
    private String address;
    private String designation;
    private String email;
    private String password;
    private String doj;

    public AdminModel(int id, int emp_code, String name, String dob, String phone, String address, String designation, String email, String password, String doj) {
        this.id = id;
        this.emp_code = emp_code;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.designation = designation;
        this.email = email;
        this.password = password;
        this.doj = doj;
    }

    public AdminModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_code() {
        return emp_code;
    }

    public void setEmp_code(int emp_code) {
        this.emp_code = emp_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
}
