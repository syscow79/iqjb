/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import oracle.iqjb.hu.pm.intf.EchoInterface;

/**
 *
 * @author martin
 */
@Stateless(name = "MyEchoService")
@Remote(EchoInterface.class)
public class EchoService implements EchoInterface{

    @Override
    public String echo(String arg) {
        return "Hello " + arg;
    }

}
