/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import oracle.iqjb.hu.pm.intf.LoggerServiceRemote;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author oracle
 */
public class JMSLoggerInterceptor {


    @EJB(lookup = "java:global/pm-logger-ear-1.0-SNAPSHOT/pm-logger-ejb-1.0-SNAPSHOT/" +
            "IqjbLogService!oracle.iqjb.hu.pm.intf.LoggerServiceRemote")
    private LoggerServiceRemote loggerServiceRemote;

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {

        loggerServiceRemote.create(ctx.getMethod().getDeclaringClass().getCanonicalName()
                + "::" + ctx.getMethod().getName());
        long start = System.currentTimeMillis();
        Object ret = ctx.proceed();
        long end = System.currentTimeMillis();
        loggerServiceRemote.create(
                LocalDateTime.now().toString() + " - " +
                        ctx.getMethod().getDeclaringClass().getCanonicalName()
                        + " - Time: " + (end - start) + "ms");

        return ret;
    }

}
