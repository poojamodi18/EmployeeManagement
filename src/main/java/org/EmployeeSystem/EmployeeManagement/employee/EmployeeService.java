package org.EmployeeSystem.EmployeeManagement.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(String departmentID) {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(emp->{
            if(emp.getDepartment().getId().equals(departmentID)){
                employees.add(emp);
            }
        });
        return employees;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Integer employeeID) {
        return employeeRepository.findById(employeeID).orElse(null);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }


    public void updateEmployee(Employee employee, Integer id) {
        employeeRepository.save(employee);
    }
}
