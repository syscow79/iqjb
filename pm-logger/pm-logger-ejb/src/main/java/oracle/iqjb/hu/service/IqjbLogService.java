/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.service;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import oracle.iqjb.hu.pm.dm.IqjbLog;
import oracle.iqjb.hu.pm.intf.LoggerServiceRemote;
import oracle.iqjb.hu.repository.IqjbLogRepository1;
import oracle.iqjb.hu.repository.IqjbLogRepository2;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
@Remote(LoggerServiceRemote.class)
public class IqjbLogService implements LoggerServiceRemote{

    @EJB
    private IqjbLogRepository2 iqjbLogRepository2;

    @EJB
    private IqjbLogRepository1 iqjbLogRepository1;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void create(String content){
        IqjbLog iqjbLog = new IqjbLog(content, new Date());
        iqjbLogRepository1.add(iqjbLog);
        iqjbLogRepository2.add(iqjbLog);
    }

}
