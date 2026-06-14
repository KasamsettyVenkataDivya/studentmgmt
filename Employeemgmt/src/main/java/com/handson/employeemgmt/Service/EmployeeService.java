package com.handson.employeemgmt.Service;

import com.handson.employeemgmt.exception.EmployeeNotFoundException;
import com.handson.employeemgmt.model.Employee;
import com.handson.employeemgmt.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public int addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {

        Employee employee = repository.findById(id);

        if(employee == null) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }

        return employee;
    }

    public int updateEmployee(Employee employee) {
        return repository.update(employee);
    }

    public int deleteEmployee(int id) {
        return repository.delete(id);
    }
}