/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oracle
 */
public class EntityManagerProducer {
    
    @Produces
    @PersistenceContext(unitName = "iqjb1PU")
    @Iqjb1Database
    
    private EntityManager em1;
    
    
    @Produces
    @PersistenceContext(unitName = "iqjb2PU")
    @Iqjb2Database
    
    private EntityManager em2;
    
}
