package org.EmployeeSystem.EmployeeManagement.employee;

import org.EmployeeSystem.EmployeeManagement.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/department/{departmentID}/employee")
    public List<Employee> getAllEmployee(@PathVariable String departmentID){
        System.out.println(departmentID);
        return employeeService.getAllEmployee();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/department/{departmentID}/employee")
    public void addEmployee(@RequestBody Employee employee, @PathVariable String departmentID){
        System.out.println(departmentID);
        System.out.println(employee);
        employee.setDepartment(new Department(departmentID," "," "));
        System.out.println(employee);
        employeeService.addEmployee(employee);
    }
}
