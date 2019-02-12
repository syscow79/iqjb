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
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.repository.DepartmentRepository1;
import oracle.iqjb.hu.repository.DepartmentRepositoryCDI1;

/**
 *
 * @author oracle
 */

public class DepartmentServiceCDI1 {

    @Inject
    private DepartmentRepositoryCDI1 departmentRepository1;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Department add(Department department)  {
        Department dep = departmentRepository1.add(department);
        return dep;
    }
    
    public List<Department> getAll(){
        return departmentRepository1.findAll();
    }
    
    public void delete(long id){
        departmentRepository1.delete(id);
    }
    
    public Department getById(long id){
        return departmentRepository1.findById(id);
    }

}
