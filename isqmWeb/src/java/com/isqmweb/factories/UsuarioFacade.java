/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isqmweb.factories;

import com.isqmweb.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ferchito
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "isqmWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario login(String documento, String contrasena) {
        Usuario usuario = null;
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.login", Usuario.class);
        query.setParameter("documento", documento);
        query.setParameter("contrasena", contrasena);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios.size() == 1) {
            usuario = usuarios.get(0);

        }
        return usuario;
    }
}
