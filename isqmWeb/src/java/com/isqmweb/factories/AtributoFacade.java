/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.factories;

import com.isqmweb.entities.Atributo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ferchito
 */
@Stateless
public class AtributoFacade extends AbstractFacade<Atributo> {

    @PersistenceContext(unitName = "isqmWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AtributoFacade() {
        super(Atributo.class);
    }
    
}
