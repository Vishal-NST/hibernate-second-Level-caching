package com.demo.hibernatesecondLevelcaching.Service;

import com.demo.hibernatesecondLevelcaching.Dto.EmployeeDto;
import com.demo.hibernatesecondLevelcaching.Entity.Employee;
import com.demo.hibernatesecondLevelcaching.ExceptionHandler.GlobalExceptionHandler;
import com.demo.hibernatesecondLevelcaching.Repository.EmployeeRepository;
import com.demo.hibernatesecondLevelcaching.config.vaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;
    @Autowired
    private static vaultConfig vaultConfig;

    @Cacheable("employees")
    public String getFemaleEmployees() {
        return employeeRepository.findByGender("Female")
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @Cacheable("employees")
    public String getMaleEmployees() {
        return employeeRepository.findByGender("Male")
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @Cacheable("employees")
    public String getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department)
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @Cacheable("employees")
    public String getEmployeesByPosition(String position) {
        return employeeRepository.findByPosition(position)
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @Cacheable("employees")
    public String getEmployeesWhoseNameStartsWithA(String prefix) {
        return employeeRepository.findByFirstNameStartingWith(prefix)
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @Cacheable("employees")
    public String getEmployeesByCity(String city) {
        return employeeRepository.findByCity(city)
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @Cacheable("employees")
    public String getActiveEmployees() {
        return employeeRepository.findByIsActive(true)
                .stream()
                .map(this::convertToDto)
                .toList().toString();
    }

    @CacheEvict(cacheNames = "employees", allEntries = true)
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        return employeeRepository.save(employee);
    }

    public static String getDbCredentials() {
        System.out.println("Username: " + vaultConfig.getUsername());
        System.out.println("Password: " + vaultConfig.getPassword());
        return "Username: " + vaultConfig.getUsername() + ", Password: " + vaultConfig.getPassword();
    }



    @CacheEvict(cacheNames = "employees", allEntries = true)
    public Employee updateEmployee(String employeeId, Employee updatedEmployeeDto) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employeeId);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            Employee updatedEmployee = convertToEntity(updatedEmployeeDto);
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setCity(updatedEmployee.getCity());
            existingEmployee.setState(updatedEmployee.getState());
            existingEmployee.setCountry(updatedEmployee.getCountry());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setPosition(updatedEmployee.getPosition());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setStartDate(updatedEmployee.getStartDate());
            existingEmployee.setActive(updatedEmployee.isActive());
            // Update other fields
            return employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }

    @CacheEvict(cacheNames = "employees", allEntries = true)
    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setGender(employeeDto.getGender());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());
        employee.setCity(employeeDto.getCity());
        employee.setState(employeeDto.getState());
        employee.setCountry(employeeDto.getCountry());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        employee.setAge(employeeDto.getAge());
        employee.setStartDate(employeeDto.getStartDate());
        employee.setActive(employeeDto.isActive());
        return employee;
    }

    public EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setGender(employee.getGender());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setCity(employee.getCity());
        employeeDto.setState(employee.getState());
        employeeDto.setCountry(employee.getCountry());
        employeeDto.setDepartment(employee.getDepartment());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setAge(employee.getAge());
        employeeDto.setStartDate(employee.getStartDate());
        employeeDto.setActive(employee.isActive());
        return employeeDto;
    }
}
