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

/**
 *
 * @author oracle
 */
public class Main {

    public static void main(String[] args) {
        try {
            Hashtable env = new Hashtable();
           env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            env.put(Context.PROVIDER_URL, "t3://localhost:7001");
              Context ctx = new InitialContext(env);
            EchoInterface echoInterface =
            (EchoInterface) ctx.lookup("java:global/pm-server-ear/pm-server-ejb/EchoService");
            System.out.println(echoInterface.echo("ejb"));
            
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
