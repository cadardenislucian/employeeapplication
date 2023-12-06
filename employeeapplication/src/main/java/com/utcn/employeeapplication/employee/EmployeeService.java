package com.utcn.employeeapplication.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employee update(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setManagerID(employee.getManagerID());
            existingEmployee.setEmail(employee.getEmail());
        }

        return existingEmployee;
    }

    @Transactional
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployeesPerDepartment(Integer departmentId) {
        return employeeRepository.getAllEmployeesPerDepartment(departmentId);
    }

    public List<Employee> getAllManagersPerDepartment(Integer departmentId) {
        return employeeRepository.getAllManagersPerDepartment(departmentId);
    }
}
