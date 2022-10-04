package com.core.mongoTesting.employeecontroller;

import com.core.mongoTesting.employeeservice.EmployeeServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServices employeeServices;

    @GetMapping("test")
    public String test(){
        return "Server is up. . . ";
    }


    @GetMapping("all-employees")
    public List<Map<String, Object>> getAllEmployee(){
        return employeeServices.getEmployee();
    }

    @GetMapping("employee")
    public Map<String, Object> getEmployeeByName(@RequestParam String empName){
        return employeeServices.getEmployeeByName(empName);
    }

    @PostMapping("insert-employee")
    public String insertEmployee(@RequestBody Map<String, Object> map){
        return employeeServices.insertEmployee(map);
    }

    @PutMapping("update-employee")
    public String updateEmployee(@RequestBody Map<String, Object> map){
        return employeeServices.updateEmployee(map);
    }

    @DeleteMapping("delete-employee")
    public String deleteEmployee(@RequestBody String empName){
        return employeeServices.deleteEmployee(empName);
    }


}
