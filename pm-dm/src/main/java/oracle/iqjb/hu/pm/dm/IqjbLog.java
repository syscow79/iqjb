/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "IqjbLog")
public class IqjbLog  extends IqjbEntity{
    
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public IqjbLog() {
    }

    public IqjbLog(String content, Date created) {
        this.content = content;
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    
    
    
 
}
