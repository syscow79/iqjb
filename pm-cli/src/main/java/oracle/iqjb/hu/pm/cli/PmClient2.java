/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.cli;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.iqjb.hu.pm.intf.EchoInterface;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentResponse;
import oracle.iqjb.hu.pm.intf.message.DepartmentSessionServiceInterface;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsRequest;
import oracle.iqjb.hu.pm.intf.message.GetAllDepartmentsResponse;

/**
 *
 * @author oracle
 */
public class PmClient2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            env.put(Context.PROVIDER_URL, "t3://localhost:7001");
            Context ctx = new InitialContext(env);
            EchoInterface echoInterface
                    = (EchoInterface) ctx.lookup("java:global/oracle.iqjb.hu_pm-server-ear_ear_1.0-SNAPSHOT/pm-server-ejb-1.0-SNAPSHOT/MyEchoService");
            System.out.println(echoInterface.echo("ejb"));

            DepartmentSessionServiceInterface departmentSessionServiceInterface
                    = (DepartmentSessionServiceInterface) ctx.lookup("java:global/oracle.iqjb.hu_pm-server-ear_ear_1.0-SNAPSHOT/pm-server-ejb-1.0-SNAPSHOT/MyDepartmentSessionService");
        //= (DepartmentSessionServiceInterface) ctx.lookup("oracle.iqjb.hu.pm.intf.message.DepartmentSessionServiceInterface");

            AddDepartmentRequest addDepartmentRequest = new AddDepartmentRequest("department6");
            AddDepartmentResponse addDepartmentResponse = departmentSessionServiceInterface.addDepartment(addDepartmentRequest);
            
            
            GetAllDepartmentsRequest getAllDepartmentsRequest = new GetAllDepartmentsRequest();
            GetAllDepartmentsResponse getAllDepartmentsResponse = departmentSessionServiceInterface.getAllDepartments(getAllDepartmentsRequest);
            
            getAllDepartmentsResponse.getDepartmentList().forEach(departmentdto->System.out.println(departmentdto.getName()));
            
        } catch (NamingException ex) {
            Logger.getLogger(PmClient2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
