package com.dsi.service.impl;

import com.dsi.dto.EmployeeDTO;
import com.dsi.mapper.EmployeeMapper;
import com.dsi.repository.EmployeeRepository;
import com.dsi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setIsAssigned(false);
        return EmployeeMapper.employeeToDTO(this.employeeRepository.save(EmployeeMapper.dtoToEmployee(employeeDTO)));
    }

    @Override
    public EmployeeDTO getEmployeeById(long employeeId) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return this.employeeRepository
                .findAll()
                .stream()
                .map(EmployeeMapper::employeeToDTO)
                .toList();
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, long employeeId) {
        return null;
    }

    @Override
    public boolean deleteEmployee(long employeeId) {
        return false;
    }

    public List<EmployeeDTO> getEmployeesByIsAssigned() {
        return this.employeeRepository
                .findEmployeesByIsAssigned(false)
                .stream()
                .map(EmployeeMapper::employeeToDTO)
                .toList();
    }
}
