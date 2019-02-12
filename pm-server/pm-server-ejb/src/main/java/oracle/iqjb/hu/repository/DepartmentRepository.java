/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import oracle.iqjb.hu.pm.dm.Department;

/**
 *
 * @author oracle
 */
public abstract class DepartmentRepository {

   protected abstract EntityManager getEntityManager();
  
    public Department add(Department department){
        getEntityManager().persist(department);
        return department;
    }
    
    public List<Department> findAll() {
        return getEntityManager().createQuery("select d from Department d", Department.class).getResultList();
    }
    
}
