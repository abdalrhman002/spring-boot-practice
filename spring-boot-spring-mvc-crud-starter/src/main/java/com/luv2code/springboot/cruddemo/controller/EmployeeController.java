package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Inject employee service object to the employee controller
    @Autowired
    public EmployeeController(EmployeeService employeeService){

        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){

        // get employees form the database
        List<Employee> employees = employeeService.findAll();

        // add employees to the model
        model.addAttribute("employees", employees);

        return "employees-list";
    }

    // add mapping for "/addEmployesForm"
    @GetMapping("/addEmployee")
    public String addEmployee(Model model){

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    // add post mapping for "/save" to add a new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    //add get mapping for "/updateEmployeeForm"
    @GetMapping("/updateEmployeeForm")
    public String updateEmployee(@RequestParam("employeeId") Integer id, Model model){

        model.addAttribute("employee",
                employeeService.findById(id));

        return "employee-form";
    }

    // add get mapping for "/deleteEmployee"
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") Integer id){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }


}
