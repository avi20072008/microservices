package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DeptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class DeptService {
    @Autowired
    private DeptRepository deptRepository;

    public Department saveDepartment(Department dept) {
        log.info("Inside Service saveDepartment");
        return deptRepository.save(dept);
    }

    public Department findDeptById(Long id) {
        //deptRepository.findById(id).orElseThrow(RuntimeException::new);
        Department dept = deptRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no department with given id"));
        return dept;
    }
}
