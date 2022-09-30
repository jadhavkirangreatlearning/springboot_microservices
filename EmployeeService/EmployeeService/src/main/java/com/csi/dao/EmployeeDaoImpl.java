package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.csi.vo.Department;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    @Autowired
    RestTemplate restTemplate;

    public Employee saveData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public RestTemplateVO getDataById(int empId){

        RestTemplateVO restTemplateVO = new RestTemplateVO();

        Employee employee = employeeRepoImpl.findByEmpId(empId);
        Department department = restTemplate.getForObject("http://DepartmentService/departments/" + employee.getDeptId(), Department.class);

        restTemplateVO.setEmployee(employee);
        restTemplateVO.setDepartment(department);

        return restTemplateVO;

    }

    public List<Employee> getAllData(){
        return employeeRepoImpl.findAll();
    }

    public Employee updateData(Employee employee){
        return employeeRepoImpl.save(employee);
    }

    public void deleteData(int empId){
        employeeRepoImpl.deleteById(empId);
    }

    public List<Employee> sortByAge(){
        return employeeRepoImpl.findAll().stream().sorted(Comparator.comparingLong(Employee::getEmpAge)).collect(Collectors.toList());
    }

    public List<Employee> sortByName(){
        return employeeRepoImpl.findAll().stream().sorted((e1, e2)-> e1.getEmpName().compareTo(e2.getEmpName())).collect(Collectors.toList());
    }

    public List<Employee> filterDataBySalary(double empSalary){
        return employeeRepoImpl.findAll().stream().filter(emp-> emp.getEmpSalary()>=empSalary).collect(Collectors.toList());
    }
}
