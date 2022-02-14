package org.EmployeeSystem.EmployeeManagement.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return  departments;
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartment(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Department department, String id) {
        departmentRepository.save(department);
        return departmentRepository.findById(id).orElse(null);
    }
}
