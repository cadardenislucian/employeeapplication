package com.utcn.employeeapplication.department;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department create(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Department update(Integer id, Department department) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);

        if (existingDepartment != null) {
            existingDepartment.setDescription(department.getDescription());
            existingDepartment.setParentID(department.getParentID());
            existingDepartment.setManagerID(department.getManagerID());
        }

        return existingDepartment;
    }

    @Transactional
    public void delete(Integer id) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);

        if (existingDepartment != null) {
            departmentRepository.delete(existingDepartment);
        }
    }
}
