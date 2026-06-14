package com.handson.employeemgmt.controller;




import com.handson.employeemgmt.model.Employee;
import com.handson.employeemgmt.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public String addEmployee(
            @RequestBody Employee employee) {

        service.addEmployee(employee);
        return "Employee Added Successfully";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(
            @PathVariable int id) {

        return service.getEmployeeById(id);
    }

    @PutMapping
    public String updateEmployee(
            @RequestBody Employee employee) {

        service.updateEmployee(employee);
        return "Employee Updated Successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(
            @PathVariable int id) {

        service.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }
}