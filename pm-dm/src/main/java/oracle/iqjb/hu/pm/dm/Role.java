/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "Role")
public class Role extends IqjbEntity{
    
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
