/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interceptor.LoggerInterceptor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.repository.DepartmentRepository2;
import oracle.iqjb.hu.repository.DepartmentRepositoryCDI2;

/**
 *
 * @author oracle
 */
public class DepartmentServiceCDI2 {


    @Inject
    private DepartmentRepositoryCDI2 departmentRepository2;
    
    

    public Department add(Department department) {
        return departmentRepository2.add(department);
    }
    
     public List<Department> getAll(){
        return departmentRepository2.findAll();
    }
    
    public void delete(long id){
        departmentRepository2.delete(id);
    }
    
    public Department getById(long id){
        return departmentRepository2.findById(id);
    }


}
