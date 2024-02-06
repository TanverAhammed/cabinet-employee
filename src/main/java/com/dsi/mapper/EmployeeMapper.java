package com.dsi.mapper;

import com.dsi.dto.EmployeeDTO;
import com.dsi.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO employeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setContact(employee.getContact());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setJoiningDate(employee.getJoiningDate());
        employeeDTO.setDesignation(employee.getDesignation());
        employeeDTO.setIsAssigned(employee.getIsAssigned());
        return employeeDTO;
    }

    public static Employee dtoToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setContact(employeeDTO.getContact());
        employee.setAddress(employeeDTO.getAddress());
        employee.setJoiningDate(employeeDTO.getJoiningDate());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setIsAssigned(employeeDTO.getIsAssigned());
        return employee;
    }

}
