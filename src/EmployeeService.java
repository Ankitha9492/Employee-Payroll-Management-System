package com.example.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.payroll.entity.Employee;
import com.example.payroll.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public void saveEmployee(Employee emp) {
        emp.calculateTotalSalary();
        repo.save(emp);
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
