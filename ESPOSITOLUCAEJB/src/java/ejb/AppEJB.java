/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author corsopd
 */
@Stateless
@LocalBean
public class AppEJB implements AppEJBRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void createApp(App a) {
        em.persist(a);
    }

    @Override
    public void deleteApp(App a) {
        em.remove(em.merge(a));
    }

    @Override
    public App updateApp(App a) {
        return em.merge(a);
    }

    @Override
    public App FindById(int id) {
        return em.createNamedQuery("FindById", App.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<App> FindByVolontarieta(String volontarieta) {
        return em.createNamedQuery("FindByVolontarieta", App.class).setParameter("volontarieta", volontarieta).getResultList();
    }

    @Override
    public List<App> FindByTecnologia(String tecnologia) {
        return em.createNamedQuery("FindByTecnologia", App.class).setParameter("tecnologia", tecnologia).getResultList();
    }

    @Override
    public List<App> FindAll() {
        return em.createNamedQuery("FindAll", App.class).getResultList();
    }

    
}
