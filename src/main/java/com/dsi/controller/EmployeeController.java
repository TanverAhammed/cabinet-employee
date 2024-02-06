package com.dsi.controller;

import com.dsi.dto.EmployeeDTO;
import com.dsi.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/add")
    public String AddEmpForm() {
        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        this.employeeService.addEmployee(employeeDTO);
        return "redirect:/employee/all";
    }

    @ResponseBody
    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployee() {
        return this.employeeService.getAllEmployee();
    }

}
