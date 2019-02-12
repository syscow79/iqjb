/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.facade;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentResponse;
import oracle.iqjb.hu.pm.intf.message.DepartmentDto;
import oracle.iqjb.hu.pm.intf.message.DepartmentSessionServiceInterface;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsRequest;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsResponse;
import oracle.iqjb.hu.repository.DepartmentRepository1;
import oracle.iqjb.hu.repository.DepartmentRepository2;
import service.DepartmentService1;
import service.DepartmentService2;

/**
 *
 * @author oracle
 */
@Stateless(name = "MyDepartmentSessionService")
@Remote(DepartmentSessionServiceInterface.class)
public class DepartmentSessionService implements DepartmentSessionServiceInterface{

    @EJB
    private DepartmentService1 departmentService1;
    
    @EJB
    private DepartmentService2 departmentService2;

    @Resource
    private SessionContext context;
   
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public AddDepartmentResponse addDepartment(AddDepartmentRequest request)  {
        AddDepartmentResponse response = new AddDepartmentResponse();
        Department department = new Department(request.getName());
        try {
            departmentService1.add(department);
        } catch (MyException ex) {
            context.setRollbackOnly();
        }
        departmentService2.add(department);
        //context.setRollbackOnly();
        
        return response;
    }

    @Override
    public GetAllDepartmentsResponse getAllDepartments(GetAllDepartmentsRequest request) {
        GetAllDepartmentsResponse response = new GetAllDepartmentsResponse();
//        departmentService2.findAll().
//                forEach(department->response.getDepartmentList().add(new DepartmentDto(department.getName(), department.getId())));

        return response;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
