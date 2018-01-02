package project.Resources;


import project.entities.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emil on 2017-12-08.
 */
@Stateless(name = "DBManager")
public class DBManager {

    @PersistenceContext(name = "dbmanager")
    EntityManager em;


    public List getBoostings(){
            TypedQuery<Service> query = em.createQuery("SELECT s FROM Service s WHERE  s.serviceType='Boosting'", Service.class);
            if(!query.getResultList().isEmpty()) {
                List<Service> services = query.getResultList();
                return services;
            } else {
                List<Service> services = new ArrayList<Service>();
                return services;
            }
    }
}
