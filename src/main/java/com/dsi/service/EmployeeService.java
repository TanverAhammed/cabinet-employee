package com.dsi.service;

import com.dsi.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(long employeeId);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, long employeeId);

    boolean deleteEmployee(long employeeId);

}
