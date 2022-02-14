package org.EmployeeSystem.EmployeeManagement.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/department")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/department")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @RequestMapping("/department/{id}")
    public Department getDepartment(@PathVariable String id){
        return departmentService.getDepartment(id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/department/{id}")
    public void deleteDepartment(@PathVariable String id){
        departmentService.deleteDepartment(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/department/{id}")
    public Department updateDepartment(@RequestBody Department department,@PathVariable String id){
        return departmentService.updateDepartment(department,id);
    }

}
