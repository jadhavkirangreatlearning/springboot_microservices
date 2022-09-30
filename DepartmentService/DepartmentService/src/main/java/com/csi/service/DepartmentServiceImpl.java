package com.csi.service;

import com.csi.dao.DepartmentDaoImpl;
import com.csi.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl {

    @Autowired
    DepartmentDaoImpl departmentDaoImpl;

    public Department saveData(Department department){
        return departmentDaoImpl.saveData(department);
    }

    public List<Department> getAllData(){
        return departmentDaoImpl.getAllData();
    }

    public Optional<Department> getDataById(int deptId){
        return departmentDaoImpl.getDataById(deptId);
    }

    public Department updateData(Department department){
        return departmentDaoImpl.updateData(department);
    }

    public void deleteData(int deptId){
        departmentDaoImpl.deleteData(deptId);
    }
}
