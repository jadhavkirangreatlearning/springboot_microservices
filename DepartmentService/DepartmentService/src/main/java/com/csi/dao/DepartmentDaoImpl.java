package com.csi.dao;

import com.csi.model.Department;
import com.csi.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDaoImpl {

    @Autowired
    DepartmentRepo departmentRepoImpl;

    public Department saveData(Department department){
        return departmentRepoImpl.save(department);
    }

    public List<Department> getAllData(){
        return departmentRepoImpl.findAll();
    }

    public Optional<Department> getDataById(int deptId){
        return departmentRepoImpl.findById(deptId);
    }

    public Department updateData(Department department){
        return departmentRepoImpl.save(department);
    }

    public void deleteData(int deptId){
        departmentRepoImpl.deleteById(deptId);
    }
}
