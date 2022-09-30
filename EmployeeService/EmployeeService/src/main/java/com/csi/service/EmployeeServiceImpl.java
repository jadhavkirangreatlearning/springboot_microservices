package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.vo.Department;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee saveData(Employee employee){
        return employeeDaoImpl.saveData(employee);
    }

    public RestTemplateVO getDataById(int empId){



        return employeeDaoImpl.getDataById(empId);

    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }

    public Employee updateData(Employee employee){
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteData(int empId){
        employeeDaoImpl.deleteData(empId);
    }

    public List<Employee> sortByAge(){
      return employeeDaoImpl.sortByAge();
    }

    public List<Employee> sortByName(){
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> filterDataBySalary(double empSalary){
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }
}
