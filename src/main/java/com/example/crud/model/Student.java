package com.example.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student") // if you don't give the table name, it will default to the class name
public class Student {
    @Id
    private int regNo;  // No auto-generation for regNo now

    @Column(name="student_name")
    private String name;

    @Column(name="student_department")
    private String department;

    @Column(name="student_percentage")
    private float percentage;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int regNo, String name, String department, float percentage) {
        this.regNo = regNo;
        this.name = name;
        this.department = department;
        this.percentage = percentage;
    }

    // Getters and Setters
    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    // toString method
    @Override
    public String toString() {
        return "Student [regNo=" + regNo + ", name=" + name + ", department=" + department + ", percentage="
                + percentage + "]";
    }
}
