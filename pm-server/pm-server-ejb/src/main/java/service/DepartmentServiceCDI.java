/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.repository.DepartmentRepositoryCDI1;

/**
 *
 * @author oracle
 */

public class DepartmentServiceCDI {


    @Inject
    private DepartmentServiceCDI1 departmentServiceCDI1;
    
    
    @Inject
    private DepartmentServiceCDI2 departmentServiceCDI2;
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Department update(Long id, Department department)  {
        Department d1 = departmentServiceCDI1.getById(id);
        Department d2 = departmentServiceCDI2.getById(id);
        d1.setName(department.getName());
        d2.setName(department.getName());
        
        
        departmentServiceCDI1.add(d1);
        department = departmentServiceCDI2.add(d2);
        return department;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Department add(Department department)  {
        departmentServiceCDI1.add(department);
        department = departmentServiceCDI2.add(department);
        return department;
    }
    
    public List<Department> getAll(){
        return departmentServiceCDI1.getAll();
    }
    
    public void delete(long id){
        departmentServiceCDI1.delete(id);
        departmentServiceCDI2.delete(id);
        
    }
    
    public Department getById(long id){
        return departmentServiceCDI2.getById(id);
    }

}
