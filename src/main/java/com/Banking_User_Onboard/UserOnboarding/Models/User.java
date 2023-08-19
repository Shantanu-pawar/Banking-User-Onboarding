package com.Banking_User_Onboard.UserOnboarding.Models;
import jakarta.persistence.*;


@Entity
@Table(name = "ActiveUsers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Email_ID", unique = true, nullable = false)
    private String email;

    private String name;

    private int salary;

    private int expense;

    User() {
    }

    public User(int id, String email, String name, int salary, int expense) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.expense = expense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }
}