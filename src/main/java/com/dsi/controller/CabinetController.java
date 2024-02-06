package com.dsi.controller;

import com.dsi.dto.CabinetDTO;
import com.dsi.entity.Cabinet;
import com.dsi.entity.Employee;
import com.dsi.mapper.CabinetMapper;
import com.dsi.repository.CabinetRepository;
import com.dsi.repository.EmployeeRepository;
import com.dsi.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cabinet")
public class CabinetController {

    @Autowired
    private CabinetRepository cabinetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/add")
    public String addCabinetWithEmployee(Model model) {
        List<Employee> employees = this.employeeRepository.findEmployeesByIsAssigned(false);
        model.addAttribute("employees", employees);
        return "add-cabinet";
    }

    @PostMapping("/save")
    public String saveCabinet(@ModelAttribute("cabinet") Cabinet cabinet) {
        for (Employee employee : cabinet.getEmployeeList()) {
            employee.setIsAssigned(true);
            employee.setCabinet(cabinet);
        }
        this.cabinetRepository.save(cabinet);
        return "redirect:/cabinet/all";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<CabinetDTO> getAllCabinet() {
        return this.cabinetRepository
                .findAll()
                .stream().map(CabinetMapper::cabinetToDTO)
                .toList();
    }

}
