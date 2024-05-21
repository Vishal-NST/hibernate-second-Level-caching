package com.demo.hibernatesecondLevelcaching.Controller;

import com.demo.hibernatesecondLevelcaching.Dto.EmployeeDto;
import com.demo.hibernatesecondLevelcaching.Entity.Employee;
import com.demo.hibernatesecondLevelcaching.ExceptionHandler.GlobalExceptionHandler;
import com.demo.hibernatesecondLevelcaching.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.hibernatesecondLevelcaching.config.vaultConfig;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/db-credentials")
    public String getDbCredentials() {
        return EmployeeService.getDbCredentials();
    }

    @GetMapping("/female")
    public ResponseEntity<?> getFemaleEmployees() {

        return ResponseEntity.ok(employeeService.getFemaleEmployees());
    }

    @GetMapping("/male")
    public ResponseEntity<?> getMaleEmployees() {
        return ResponseEntity.ok(employeeService.getMaleEmployees());
    }

    @GetMapping("/byDepartment")
    public ResponseEntity<?> getEmployeesByDepartment(@RequestParam String department) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(department));
    }

    @GetMapping("/byPosition")
    public ResponseEntity<?> getEmployeesByPosition(@RequestParam String position) {
        return ResponseEntity.ok(employeeService.getEmployeesByPosition(position));
    }

    @GetMapping("/startsWithA")
    public ResponseEntity<?> getEmployeesWhoseNameStartsWithA(@RequestParam String prefix) {
        return ResponseEntity.ok(employeeService.getEmployeesWhoseNameStartsWithA(prefix));
    }

    @GetMapping("/byCity")
    public ResponseEntity<?> getEmployeesByCity(@RequestParam String city) {
        return ResponseEntity.ok(employeeService.getEmployeesByCity(city));
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveEmployees() {

        return ResponseEntity.ok(employeeService.getActiveEmployees());
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee createdEmployee = employeeService.createEmployee(employeeDto);
        EmployeeDto createdEmployeeDto = employeeService.convertToDto(createdEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployeeDto);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
