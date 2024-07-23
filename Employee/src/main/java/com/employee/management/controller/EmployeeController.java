package com.employee.management.controller;


import com.employee.management.constants.EmployeeConstants;
import com.employee.management.dto.EmployeeDto;
import com.employee.management.dto.ErrorResponseDto;
import com.employee.management.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.employee.management.service.iEmployeeService;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(
        name = "CRUD Rest API for employee management",
        description = "This Rest API supports Create, Delete, Update, Fetch Operations"
)
public class EmployeeController {

    private iEmployeeService iEmployeeService;

    @Operation(
            summary = "Create Employee Rest API",
            description = "Rest Api to create new Employees"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status 500",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        iEmployeeService.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(EmployeeConstants.STATUS_201, EmployeeConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Employee details Rest API",
            description = "Rest Api to create new Employee details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status 500",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<EmployeeDto> fetchById(@RequestParam @Valid Integer id) {
        EmployeeDto employeeDto = iEmployeeService.fetchById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeDto);
    }

    @Operation(
            summary = "Update Employee details Rest API",
            description = "Rest Api to update Employee details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status 417"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status 500",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeeDetails(@Valid @RequestBody EmployeeDto employeeDto) {
        boolean isUpdated = iEmployeeService.updateEmployee(employeeDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(EmployeeConstants.STATUS_200, EmployeeConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(EmployeeConstants.STATUS_417, EmployeeConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Employee details Rest API",
            description = "Rest Api to delete Employee details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Exception failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status 500",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @DeleteMapping("/delete")
    ResponseEntity<ResponseDto> deleteEmployee(@RequestParam @Valid Integer id) {
        boolean isDelete = iEmployeeService.deleteEmployee(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(EmployeeConstants.STATUS_200, EmployeeConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(EmployeeConstants.STATUS_500, EmployeeConstants.MESSAGE_500));
        }
    }
}
