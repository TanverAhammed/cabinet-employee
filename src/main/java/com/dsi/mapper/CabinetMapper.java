package com.dsi.mapper;

import com.dsi.dto.CabinetDTO;
import com.dsi.dto.EmployeeDTO;
import com.dsi.entity.Cabinet;

import java.util.List;

public class CabinetMapper {

    public static CabinetDTO cabinetToDTO(Cabinet cabinet) {
        CabinetDTO cabinetDTO = new CabinetDTO();
        cabinetDTO.setId(cabinet.getId());
        cabinetDTO.setName(cabinet.getName());
        List<EmployeeDTO> employeeDTOS = cabinet.getEmployeeList().stream().map(EmployeeMapper::employeeToDTO).toList();
        cabinetDTO.setEmployeeList(employeeDTOS);
        return cabinetDTO;
    }

}
