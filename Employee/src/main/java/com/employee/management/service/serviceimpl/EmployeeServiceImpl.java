package com.employee.management.service.serviceimpl;


import com.employee.management.entity.Employee;
import com.employee.management.exception.EmployeeAlreadyExistsException;
import com.employee.management.exception.ResourceNotFoundException;
import com.employee.management.mapper.EmployeeMapper;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.iEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.employee.management.dto.EmployeeDto;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements iEmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto, new Employee());
        Optional<Employee> optionalEmployee = employeeRepository.findByMobileNumber(employeeDto.getMobileNumber());
        if (optionalEmployee.isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already exists with mobile number" + employeeDto.getMobileNumber());
        }
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto fetchById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", String.valueOf(id)));
        EmployeeDto dto = EmployeeMapper.mapToEmployeeDto(employee, new EmployeeDto());
        return dto;
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        boolean isUpdated = false;
        Employee employee = employeeRepository.findByMobileNumber(employeeDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Mobile Number", employeeDto.getMobileNumber())
        );
        EmployeeMapper.mapToEmployee(employeeDto, employee);
        employeeRepository.save(employee);
        return isUpdated;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", String.valueOf(id)));
        employeeRepository.deleteById(id);
        return true;
    }
}
