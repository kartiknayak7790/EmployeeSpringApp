package com.employee.management.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(name="Employee", description = "Represents employee database schema")
public class EmployeeDto {
    @NotEmpty(message = "Mobile number should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(description = "Represents mobile number of customer", example = "1234512345")
    private String mobileNumber;
    @NotEmpty(message = "Employee Name should not be empty")
    @Schema(description = "Represents Name of employee")
    private String firstName;

    @Schema(description = "Represents lastName of employee")
    private String lastName;

    @NotEmpty(message = "Department Name should not be empty")
    @Schema(description = "Represents Name of department")
    private String departmentName;

    @NotEmpty(message = "Location should not be empty")
    @Schema(description = "Represents location of department")
    private String location;
}
