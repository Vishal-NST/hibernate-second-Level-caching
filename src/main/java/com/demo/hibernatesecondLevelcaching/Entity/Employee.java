package com.demo.hibernatesecondLevelcaching.Entity;

import com.demo.hibernatesecondLevelcaching.Dto.EmployeeDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "Employees_cache")
@Entity
@Cacheable
@Cache(region = "EmployeeCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee extends EmployeeDto {
    @Id
    @Column(name = "emp_id")
    private String employeeId;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="gender")
    private String gender;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "age")
    private int age;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "is_active")
    private boolean isActive;

//    public Employee(String employeeId, String firstName, String lastName, String gender, String email, String phoneNumber,
//                    String address, String city, String state, String country, String department, String position, double salary,
//                    int age, String startDate, boolean isActive) {
//        this.employeeId = employeeId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.gender=gender;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.department = department;
//        this.position = position;
//        this.salary = salary;
//        this.age = age;
//        this.startDate = startDate;
//        this.isActive = isActive;
//    }
//
//    //Constructor
//    public Employee() {
//    }
//
//    // Equals and HashCode
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Double
//                .compare(employee.salary, salary) == 0 && age == employee.age && isActive == employee.isActive && Objects
//                .equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects
//                .equals(lastName, employee.lastName)&& Objects.equals(gender, employee.gender) && Objects.equals(email, employee.email) && Objects.
//                equals(phoneNumber, employee.phoneNumber) && Objects.equals(address, employee.address) && Objects.equals(city, employee.city) && Objects.
//                equals(state, employee.state) && Objects.equals(country, employee.country) && Objects.equals(department, employee.department) && Objects
//                .equals(position, employee.position) && Objects.equals(startDate, employee.startDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(employeeId, firstName, lastName, gender,email, phoneNumber, address, city, state, country, department, position, salary, age, startDate, isActive);
//    }
//
//    // ToString
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "employeeId='" + employeeId + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", gender='" +gender+'\''+
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", address='" + address + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", country='" + country + '\'' +
//                ", department='" + department + '\'' +
//                ", position='" + position + '\'' +
//                ", salary=" + salary +
//                ", age=" + age +
//                ", startDate='" + startDate + '\'' +
//                ", isActive=" + isActive +
//                '}';
//    }
//
}
