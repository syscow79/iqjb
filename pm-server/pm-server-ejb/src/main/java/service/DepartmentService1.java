/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import interceptor.LoggerInterceptor;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.dm.IqjbLog;
import oracle.iqjb.hu.repository.DepartmentRepository1;
import oracle.iqjb.hu.repository.IqjbLogRepoTest;

import java.util.Date;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class DepartmentService1 {

    @EJB
    private DepartmentRepository1 departmentRepository1;

    @EJB
    private DepartmentService1 departmentService1;

    @EJB
    private IqjbLogRepoTest iqjbLogRepoTest;

    //@Interceptors(LoggerInterceptor.class)
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Department add(Department department) throws MyException {
        Department dep = departmentRepository1.add(department);
        log("test REQUIRES_NEW this");
        departmentService1.log("test REQUIRES_NEW proxy");
        if (1==1){
            throw new MyException("hiba");
        }
        return dep;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void log(String message) throws MyException {
        IqjbLog iqjbLog = new IqjbLog(message, new Date());
        iqjbLogRepoTest.add(iqjbLog);
    }


}
