package com.csi.controller;

import com.csi.exception.DepartmentRecordNotFoundException;
import com.csi.model.Department;
import com.csi.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentServiceImpl;

    @PostMapping("/")
    public ResponseEntity<Department> saveData(@Valid @RequestBody Department department){
        Department department1 = departmentServiceImpl.saveData(department);

      return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Optional<Department>> getDataById(@PathVariable int deptId){
        return ResponseEntity.ok(departmentServiceImpl.getDataById(deptId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAllData(){
        return ResponseEntity.ok(departmentServiceImpl.getAllData());
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<Department> updateData(@Valid @PathVariable int deptId, @RequestBody Department department) throws DepartmentRecordNotFoundException {

        //

        Department department1 = departmentServiceImpl.getDataById(deptId).orElseThrow(()-> new DepartmentRecordNotFoundException("Department Id Does Not Exist"));

        department1.setDeptName(department.getDeptName());
        department1.setDeptCode(department.getDeptCode());
        department1.setDeptLaunchDate(department.getDeptLaunchDate());
        return ResponseEntity.ok(departmentServiceImpl.updateData(department1));
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> deleteData(@PathVariable int deptId){
        departmentServiceImpl.deleteData(deptId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

}
