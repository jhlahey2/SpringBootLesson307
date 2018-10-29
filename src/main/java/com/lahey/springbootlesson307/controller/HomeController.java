package com.lahey.springbootlesson307.controller;

import com.lahey.springbootlesson307.model.Employee;
import com.lahey.springbootlesson307.model.EmployeeRepository;
import com.lahey.springbootlesson307.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){

        //first lets create an Employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        //now lets create a laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");

        //add the laptop to the employee
        employee.setLaptop(laptop);

        //save the employee to the database
        employeeRepository.save(employee);

        //grab all the employees from the database and send them to the template
        model.addAttribute("employees", employeeRepository.findAll());
        return("index");

    }//end public String index(Model model)

}
