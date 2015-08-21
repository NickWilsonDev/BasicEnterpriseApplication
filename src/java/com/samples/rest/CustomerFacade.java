/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.rest;

import com.samples.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nick
 */
@Stateless
public class CustomerFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "ServerSidePU")
    private EntityManager em;
    
    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c").getResultList();
    }
    
    public List<Customer> findByName(String name) {
        return em.createQuery("select c from Customer c where " + "UPPER(c.name) LIKE :custName").
                               setParameter("custName", "%" + name.toUpperCase() + "%").getResultList();
    }

}
