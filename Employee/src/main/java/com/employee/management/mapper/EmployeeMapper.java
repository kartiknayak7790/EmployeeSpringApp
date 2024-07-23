package com.employee.management.mapper;


import com.employee.management.dto.EmployeeDto;
import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setMobileNumber(employee.getMobileNumber());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDepartmentName(employee.getDepartment().getName());
        employeeDto.setLocation(employee.getDepartment().getLocation());
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto, Employee employee) {
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        Department department = new Department();
        department.setName(employeeDto.getDepartmentName());
        department.setLocation(employeeDto.getLocation());
        employee.setDepartment(department);

        return employee;
    }

}