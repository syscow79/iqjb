/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "Task")
public class Task extends IqjbEntity{
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "ownerId", referencedColumnName = "id")
    private Employee owner;
    
    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;
            

    public Task() {
    }

    public Task(String name, Employee owner) {
        this.name = name;
        this.owner = owner;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
    
    
}
