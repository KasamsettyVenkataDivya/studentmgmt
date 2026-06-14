package com.handson.employeemgmt.repository;
import com.handson.employeemgmt.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Insert Employee
    public int save(Employee employee) {

        String sql =
                "INSERT INTO employee(name,email,department,salary) VALUES(?,?,?,?)";

        return jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary());
    }

    // Get All Employees
    public List<Employee> findAll() {

        String sql = "SELECT * FROM employee";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
    }

    // Get Employee By Id
    public Employee findById(int id) {

        String sql =
                "SELECT * FROM employee WHERE id=?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, rowNum) ->
                        new Employee(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("department"),
                                rs.getDouble("salary")
                        ));
    }

    // Update Employee
    public int update(Employee employee) {

        String sql =
                "UPDATE employee SET name=?, email=?, department=?, salary=? WHERE id=?";

        return jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getId()
        );
    }

    // Delete Employee
    public int delete(int id) {

        String sql =
                "DELETE FROM employee WHERE id=?";

        return jdbcTemplate.update(sql, id);
    }
}