package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private int empId;

    @Size(min = 2, message = "Employee name atleast 2 character")
    private String empName;

    @Size(min = 4, message = "Employee Address should be more than 4 character")
    private String empAddress;

    private double empSalary;

    private int empAge;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date empDOB;

    private int deptId;
}
