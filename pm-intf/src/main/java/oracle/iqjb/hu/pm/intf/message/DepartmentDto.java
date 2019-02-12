/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.intf.message;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class DepartmentDto implements Serializable{
    private String name;
    private Long id;

    public DepartmentDto() {
    }

    public DepartmentDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
