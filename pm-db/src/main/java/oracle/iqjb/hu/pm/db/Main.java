/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.db;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import oracle.iqjb.hu.pm.dm.Address;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.dm.Employee;
import oracle.iqjb.hu.pm.dm.Project;
import oracle.iqjb.hu.pm.dm.Role;
import oracle.iqjb.hu.pm.dm.Task;

/**
 *
 * @author oracle
 */
public class Main {

    public static void main(String[] args) {
        loadToDatabase("iqjb1PU");
        loadToDatabase("iqjb2PU");
    }

    private static void loadToDatabase(String pu) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pu);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        
        Department department1 = new Department("department1");
        em.persist(department1);
        
        Department department2 = new Department("department2");
        em.persist(department2);
        
        Department department3 = new Department("department3");
        em.persist(department3);
        
        Role role1 = new Role("user");
        em.persist(role1);
        
        Role role2 = new Role("admin");
        em.persist(role2);
        
        
        
        Employee employeee = new Employee();
        employeee.setLastName("lastname1");
        employeee.setFirstName("firstname1");
        employeee.setLoginName("loginname1");
        employeee.setPassword("password1");
        employeee.setTitle("title1");
        employeee.setSalary(10000);
        employeee.getRoles().add(role2);
        employeee.setDepartment(department1);
        employeee.setAddress(new Address("1111", "city1", "street1"));
        em.persist(employeee);
        

        Employee employeee2 = new Employee();
        employeee2.setLastName("lastname2");
        employeee2.setFirstName("firstname2");
        employeee2.setLoginName("loginname2");
        employeee2.setPassword("password2");
        employeee2.setTitle("title2");
        employeee2.setSalary(20000);
        employeee2.setDepartment(department2);
        employeee2.setBoss(employeee);
        employeee2.getRoles().add(role1);
        employeee2.setAddress(new Address("2222", "city2", "street2"));
        em.persist(employeee2);

        Employee employeee3 = new Employee();
        employeee3.setLastName("lastname3");
        employeee3.setFirstName("firstname3");
        employeee3.setLoginName("loginname3");
        employeee3.setPassword("password3");
        employeee3.setTitle("title3");
        employeee3.setSalary(30000);
        employeee3.setDepartment(department3);
        employeee3.getRoles().add(role1);
        employeee3.getRoles().add(role2);
        employeee3.setAddress(new Address("3333", "city3", "street3"));
        employeee3.setBoss(employeee2);
        em.persist(employeee3);
        
        
        Project project1 = new Project();
        project1.setName("project1");
        project1.setFromDate(Date.from(LocalDate.now().minusDays(7).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        project1.setToDate(Date.from(LocalDate.now().plusDays(7).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        project1.setLeader(employeee);
        project1.getTasks().add(new Task("task1", employeee2));
        project1.getTasks().add(new Task("task2", employeee3));
        em.persist(project1);

        
        
        Project project2 = new Project();
        project2.setName("project2");
        project2.setFromDate(Date.from(LocalDate.now().minusDays(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        project2.setToDate(Date.from(LocalDate.now().plusDays(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        project2.setLeader(employeee);
        project2.getTasks().add(new Task("task3", employeee2));
        project2.getTasks().add(new Task("task4", employeee3));
        em.persist(project2);

        
        
        em.getTransaction().commit();
    }

}
