package com.employee.management.service;


import com.employee.management.dto.EmployeeDto;

public interface iEmployeeService {
     void createEmployee(EmployeeDto dto);

     EmployeeDto fetchById(int id);

     boolean updateEmployee(EmployeeDto dto);

     boolean deleteEmployee(int id);
}
