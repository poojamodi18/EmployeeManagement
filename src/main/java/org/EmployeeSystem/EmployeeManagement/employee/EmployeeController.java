package org.EmployeeSystem.EmployeeManagement.employee;

import org.EmployeeSystem.EmployeeManagement.department.Department;
import org.EmployeeSystem.EmployeeManagement.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/department/{departmentID}/employee")
    public List<Employee> getAllEmployee(@PathVariable String departmentID){
        System.out.println(departmentID);
        return employeeService.getAllEmployee(departmentID);
    }

    @RequestMapping("/department/{departmentID}/employee/{employeeID}")
    public Employee getEmployee(@PathVariable Integer employeeID){
        return employeeService.getEmployee(employeeID);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/department/{departmentID}/employee")
    public void addEmployee(@RequestBody Employee employee, @PathVariable String departmentID){
        System.out.println(departmentID);
        System.out.println(employee);
        employee.setDepartment(departmentService.getDepartment(departmentID));
        System.out.println(employee);
        employeeService.addEmployee(employee);
    }
}
