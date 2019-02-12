/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.iqjb.hu.pm.intf.LoggerServiceRemote;

/**
 * @author oracle
 */
public class LoggerInterceptor {


    @EJB(lookup = "java:global/pm-logger-ear-1.0-SNAPSHOT/pm-logger-ejb-1.0-SNAPSHOT/" +
            "IqjbLogService!oracle.iqjb.hu.pm.intf.LoggerServiceRemote")
    private LoggerServiceRemote loggerServiceRemote;

    @Resource
    private EJBContext context;

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {

        loggerServiceRemote.create(ctx.getMethod().getDeclaringClass().getCanonicalName()
                + "::" + ctx.getMethod().getName() + " is called by " + context.getCallerPrincipal().getName());
        long start = System.currentTimeMillis();
        Object ret = ctx.proceed();
        long end = System.currentTimeMillis();
        loggerServiceRemote.create(
                LocalDateTime.now().toString() + " - " +
                        ctx.getMethod().getDeclaringClass().getCanonicalName()
                        + "::" + ctx.getMethod().getName() + " is called by " + context.getCallerPrincipal().getName() +
                        " - Time: " + (end - start) + "ms");
        return ret;
    }

    private LoggerServiceRemote lookupIqjbLogServiceRemote() {
        try {
            Context c = new InitialContext();
            return (LoggerServiceRemote) c.lookup("java:global/pm-logger-ear-1.0-SNAPSHOT/pm-logger-ejb-1.0-SNAPSHOT/IqjbLogService!oracle.iqjb.hu.pm.intf.LoggerServiceRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
