package com.utcn.employeeapplication.employee;

import com.utcn.employeeapplication.department.Department;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer managerID;
    private String email;

    @ManyToOne
    private Department department;
}
