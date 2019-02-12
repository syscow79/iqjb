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
import javax.transaction.Transactional;
import oracle.iqjb.hu.pm.dm.Department;

/**
 *
 * @author oracle
 */
@Transactional(Transactional.TxType.REQUIRED)
public abstract class DepartmentRepositoryCDI {

   protected abstract EntityManager getEntityManager();
  
    public Department add(Department department){
        if (department.getId() == null){
            getEntityManager().persist(department);
        } else {
            getEntityManager().merge(department);
        }
        getEntityManager().flush();
        return department;
    }
    
    public List<Department> findAll() {
        return getEntityManager().createQuery("select d from Department d", Department.class).getResultList();
    }
    
    public void delete(long id){
        getEntityManager().remove(getEntityManager().find(Department.class, id));
    }
    
    
    public Department findById(long id){
        return getEntityManager().find(Department.class, id);
    }
}
