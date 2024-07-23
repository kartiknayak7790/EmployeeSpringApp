package com.employee.management.repository;


import com.employee.management.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findById(int id);

    Optional<Employee> findByMobileNumber(String mobileNumber);

    @Transactional
    @Modifying
    void deleteById(int id);
}
