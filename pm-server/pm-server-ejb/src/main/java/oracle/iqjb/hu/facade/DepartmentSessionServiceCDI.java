/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.facade;

import event.IqjbLogCreatedEvent1;
import event.IqjbLogCreatedEvent2;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.dm.IqjbLog;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentResponse;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsRequest;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsResponse;
import producer.MyClass;
import producer.MyClassQualifier;
import service.DepartmentServiceCDI1;
import service.DepartmentServiceCDI2;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author oracle
 */
@Transactional(Transactional.TxType.REQUIRED)
public class DepartmentSessionServiceCDI {

    @Inject
    private ServletContext servletContext;

    @Inject
    private HttpSession httpSession;

    @Inject
    private DepartmentServiceCDI1 departmentService1;

    @Inject
    private DepartmentServiceCDI2 departmentService2;

    @Inject
    @MyClassQualifier
    private MyClass myClass;


    @Inject
    @Named("aaa")
    private MyClass myClass1;


    @Inject
    @Named("bbb")
    private MyClass myClass2;


    @Inject
    @Named("create3")
    private MyClass myClass3;

    @Inject
    @IqjbLogCreatedEvent1
    private Event<IqjbLog> logEvent1;


    @Inject
    @IqjbLogCreatedEvent2
    private Event<IqjbLog> logEvent2;


    public AddDepartmentResponse addDepartment(AddDepartmentRequest request) throws MyException {
        AddDepartmentResponse response = new AddDepartmentResponse();
        Department department = new Department(request.getName());
        departmentService1.add(department);
        departmentService2.add(department);

        logEvent1.fire(new IqjbLog("event is created", new Date()));
        logEvent2.fire(new IqjbLog("event is created", new Date()));
        System.out.println(myClass.getName() + " - " + myClass.getTitle());

        System.out.println(myClass1.getName() + " - " + myClass1.getTitle());

        System.out.println(myClass2.getName() + " - " + myClass2.getTitle());

        System.out.println(myClass3.getName() + " - " + myClass3.getTitle());


        //httpSession.getAttributeNames()
        return response;
    }


    public GetAllDepartmentsResponse getAllDepartments(GetAllDepartmentsRequest request) {
        GetAllDepartmentsResponse response = new GetAllDepartmentsResponse();
//        departmentService2.findAll().
//                forEach(department->response.getDepartmentList().add(new DepartmentDto(department.getName(), department.getId())));

        return response;
    }

}
