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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import oracle.iqjb.hu.pm.dm.Department;
import producer.Iqjb1Database;

/**
 *
 * @author oracle
 */
@Transactional(Transactional.TxType.REQUIRED)
public class DepartmentRepositoryCDI1 extends DepartmentRepositoryCDI {

    @Inject
    @Iqjb1Database
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
