/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author oracle
 */
@Entity
@Table(name = "Employee")
public class Employee extends IqjbEntity{

    private String loginName;
    private String firstName;
    private String lastName;
    private String password;
    private String title;
    private int salary;
    
    
    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "id")
    private Department department;
    
    
    @ManyToOne
    @JoinColumn(name = "bossId", referencedColumnName = "id")
    private Employee boss;
    
    @Embedded
    private Address address;
    
    @ManyToMany
    @JoinTable(name = "EmployeeRoles", 
	joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    private Set<Role> roles;

    public Employee() {
        this.roles = new HashSet<>();
    }

    
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    
    
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    
    
    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    

    @Override
    public String toString() {
        return "oracle.iqjb.hu.pm.dm.Employeee[ id=" + id + " ]";
    }
    
}
