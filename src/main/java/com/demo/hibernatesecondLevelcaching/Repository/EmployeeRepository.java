package com.demo.hibernatesecondLevelcaching.Repository;

import com.demo.hibernatesecondLevelcaching.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByGender(String gender);
    List<Employee> findByDepartment(String department);
    List<Employee> findByPosition(String position);
    List<Employee> findByFirstNameStartingWith(String prefix);
    List<Employee> findByCity(String city);
    List<Employee> findByIsActive(boolean isActive);
}