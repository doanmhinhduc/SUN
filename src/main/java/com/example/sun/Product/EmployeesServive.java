package com.example.sun.Product;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeesServive {
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Employees> findAll(){return employeesRepository.findAll();}

    public Optional<Employees> findById(int id) {
        return employeesRepository.findById((id));
    }

    public Employees save(Employees employees) {
        return employeesRepository.save(employees);
    }

    public void deleteById(int id) {
        employeesRepository.deleteById((id));
    }
}
