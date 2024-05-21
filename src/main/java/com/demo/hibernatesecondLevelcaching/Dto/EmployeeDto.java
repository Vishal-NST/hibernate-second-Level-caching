package com.demo.hibernatesecondLevelcaching.Dto;

import com.demo.hibernatesecondLevelcaching.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String department;
    private String position;
    private double salary;
    private int age;
    private String startDate;
    private boolean isActive;
}
