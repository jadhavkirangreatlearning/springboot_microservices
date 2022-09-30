package com.csi.controller;

import com.csi.exception.EmployeeRecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.csi.service.EmployeeServiceImpl;
import com.csi.vo.RestTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeRepo employeeRepoImpl;

    @PostMapping("/")
    public ResponseEntity<Employee> saveData(@Valid @RequestBody Employee employee){
        log.info("#################Trying to save Data for Employee: "+ employee.getEmpName());
        return new ResponseEntity<>(employeeServiceImpl.saveData(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<RestTemplateVO> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) throws EmployeeRecordNotFoundException {
        //
       /* flag = false;

        condition(emp.getId==empId) {
        flag= true;
        }

        if(flag){


        }else{
            throw new EmployeeRecordNotFoundException("");
        }*/


        Employee employee1 = employeeRepoImpl.findById(empId).orElseThrow(()-> new EmployeeRecordNotFoundException("Employee Id Does not exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setDeptId(employee.getDeptId());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpAge(employee.getEmpAge());


        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteData(@PathVariable int empId){
        employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge(){
        return ResponseEntity.ok(employeeServiceImpl.sortByAge());
    }

    @GetMapping("sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }

    @GetMapping("/filterbysalary/{empSalary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }

}
