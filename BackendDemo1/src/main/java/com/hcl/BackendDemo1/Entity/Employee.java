package com.hcl.BackendDemo1.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dob;
    private String email;
    private String department;
    private String designation;
    @Column(name = "reporting_manager")
    private String reportingManager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Employee() {
    }

    public Employee(int id, String name, String dob, String email, String department, String designation, String reportingManager) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.reportingManager = reportingManager;
    }

    public Employee(String name, String dob, String email, String department, String designation, String reportingManager) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.reportingManager = reportingManager;
    }

    public Employee(int id, String name, String dob, String email, String department, String designation, String reportingManager, User user) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.reportingManager = reportingManager;
        this.user = user;
    }

    public Employee(String name, String dob, String email, String department, String designation, String reportingManager, User user) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.reportingManager = reportingManager;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
