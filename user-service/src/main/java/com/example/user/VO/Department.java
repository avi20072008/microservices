package com.example.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long deptId;

    private String deptName;
    private String deptAddr;
    private String deptCode;
}
