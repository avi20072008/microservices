package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depts")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/")
    public Department saveDept(@RequestBody Department dept){
        log.info("Inside saveDepartment method");
       return deptService.saveDepartment(dept);
    }
    @GetMapping("/{id}")
    public Department findDeptById(@PathVariable Long id){
        return deptService.findDeptById(id);
    }
}
