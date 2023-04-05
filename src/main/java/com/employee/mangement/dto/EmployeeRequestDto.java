package com.employee.mangement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class EmployeeRequestDto {

    private String name;
    private String mailId;
    private String department;
    private Long salary;

}