package com.utcn.employeeapplication.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.update(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllEmployeesPerDepartment/{departmentId}")
    public ResponseEntity<List<Employee>> getAllEmployeesPerDepartment(@PathVariable Integer departmentId) {
        List<Employee> employees = employeeService.getAllEmployeesPerDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/getAllManagersPerDepartment/{departmentId}")
    public ResponseEntity<List<Employee>> getAllManagersPerDepartment(@PathVariable Integer departmentId) {
        List<Employee> managers = employeeService.getAllManagersPerDepartment(departmentId);
        return ResponseEntity.ok(managers);
    }
}
