package com.example.sun.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/Employees")
public class EmployeesApi {

    @Autowired
    EmployeesRepository employeesRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Employees> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit){
        return employeesRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employees save(@RequestBody Employees employees){
        employeesRepository.save(employees);
        return employees;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Employees finById(@PathVariable int id){
        return employeesRepository.findById(id).get();

    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Employees update(@PathVariable int id, @RequestBody Employees updateProduct){
        Employees existing = employeesRepository.findById(id).get();
        existing.setName(updateProduct.getName());
        existing.setWage(updateProduct.getWage());
        employeesRepository.save(existing);
        return updateProduct ;
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        employeesRepository.deleteById(id);
        return true;
    }
}
