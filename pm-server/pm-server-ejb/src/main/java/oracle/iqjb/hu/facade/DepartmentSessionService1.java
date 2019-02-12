/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.facade;

import interceptor.LoggerInterceptor;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.intf.LoggerServiceRemote;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentResponse;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsRequest;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsResponse;
import service.DepartmentService1;
import service.DepartmentService2;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class DepartmentSessionService1 {

    //@EJB(lookup = "java:global/oracle.iqjb.hu_pm-logger-ear_ear_1.0-SNAPSHOT/pm-logger-ejb-1.0-SNAPSHOT/IqjbLogService!oracle.iqjb.hu.pm.intf.LoggerServiceRemote")
    //private LoggerServiceRemote loggerServiceRemote;


    @EJB
    private DepartmentService1 departmentService1;

    @EJB
    private DepartmentService2 departmentService2;
    
    @Resource
    private SessionContext context;
    
    @Resource
    private TimerService timerService;

    //@Interceptors(LoggerInterceptor.class)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public AddDepartmentResponse addDepartment(AddDepartmentRequest request) throws MyException {
        AddDepartmentResponse response = new AddDepartmentResponse();
        Department department = new Department(request.getName());
        departmentService1.add(department);
        departmentService2.add(department);

        timerService.createTimer(20000, "email is sent");
        return response;
    }
    
    @Timeout
    public void sendEmail(Timer timer){
        //loggerServiceRemote.create(LocalDateTime.now().toString() + " - " + (String)timer.getInfo() );
        System.out.println(LocalDateTime.now().toString() + " - " + (String)timer.getInfo());
    }

    public GetAllDepartmentsResponse getAllDepartments(GetAllDepartmentsRequest request) {
        GetAllDepartmentsResponse response = new GetAllDepartmentsResponse();
//        departmentService2.findAll().
//                forEach(department->response.getDepartmentList().add(new DepartmentDto(department.getName(), department.getId())));

        return response;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
