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
public class Department {
    @Id
    private int deptId;

    @Size(min = 2, message = "Department name atleast 2 character")
    private String deptName;

    @Size(min = 3, message = "Department code atleast 3 character")
    private String deptCode;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date deptLaunchDate;
}
