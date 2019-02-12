/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import producer.Iqjb1Database;
import producer.Iqjb2Database;

/**
 *
 * @author oracle
 */
@Transactional(Transactional.TxType.REQUIRED)
public class DepartmentRepositoryCDI2 extends DepartmentRepositoryCDI {

    @Inject
    @Iqjb2Database
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
