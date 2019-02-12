/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "Project")
public class Project extends IqjbEntity {

    private String name;
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "leaderId", referencedColumnName = "id")
    private Employee leader;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    List<Task> tasks;
    
    public Project() {
        this.tasks = new ArrayList<>();
    }

    public Project(String name, Date fromDate, Date toDate, Employee leader) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leader = leader;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }
    
    
}
