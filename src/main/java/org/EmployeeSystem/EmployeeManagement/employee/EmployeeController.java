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
        return employeeService.getAllEmployee(departmentID);
    }

    @RequestMapping("/department/{departmentID}/employee/{employeeID}")
    public Employee getEmployee(@PathVariable Integer employeeID){
        return employeeService.getEmployee(employeeID);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/department/{departmentID}/employee")
    public void addEmployee(@RequestBody Employee employee, @PathVariable String departmentID){
//        employee.setDepartment(departmentService.getDepartment(departmentID));
        employee.setDepartment(new Department(departmentID,"",""));
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/department/{departmentID}/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/department/{departmentID}/employee/{id}")
    public void updateEmployee(@RequestBody Employee employee,@PathVariable Integer id,@PathVariable String departmentID){
        employee.setDepartment(new Department(departmentID,"",""));
        employeeService.updateEmployee(employee,id);
    }

}
