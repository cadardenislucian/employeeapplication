package com.utcn.employeeapplication.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.department.departmentID = :departmentId")
    List<Employee> getAllEmployeesPerDepartment(@Param("departmentId") Integer departmentId);

    @Query("SELECT e FROM Employee e WHERE e.department.departmentID = :departmentId AND e.managerID IS NULL")
    List<Employee> getAllManagersPerDepartment(@Param("departmentId") Integer departmentId);
}
