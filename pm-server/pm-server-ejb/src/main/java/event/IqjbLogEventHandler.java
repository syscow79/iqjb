/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.io.Serializable;
import javax.enterprise.event.Observes;
import oracle.iqjb.hu.pm.dm.IqjbLog;

/**
 *
 * @author oracle
 */
public class IqjbLogEventHandler implements Serializable{
    public void receiveLog1(@Observes @IqjbLogCreatedEvent1 IqjbLog iqjbLog){
        System.out.println("1 - " + iqjbLog.getContent());
    }
    
    public void receiveLog11(@Observes @IqjbLogCreatedEvent1 IqjbLog iqjbLog){
        System.out.println("11 - " + iqjbLog.getContent());
    }
    
    
    public void receiveLog2(@Observes @IqjbLogCreatedEvent2 IqjbLog iqjbLog){
        System.out.println("2 - " + iqjbLog.getContent());
    }
    
    public void receiveLog22(@Observes @IqjbLogCreatedEvent2 IqjbLog iqjbLog){
        System.out.println("22 - " + iqjbLog.getContent());
    }
    
}
