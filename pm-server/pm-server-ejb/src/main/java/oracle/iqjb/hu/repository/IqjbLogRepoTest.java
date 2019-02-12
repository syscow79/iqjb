/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.repository;

import oracle.iqjb.hu.pm.dm.IqjbLog;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class IqjbLogRepoTest {

    public IqjbLog add(IqjbLog entity){
        em.persist(entity);
        return entity;
    }

    @PersistenceContext(unitName = "iqjb1PU")
    private EntityManager em;

}
