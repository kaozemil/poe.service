package project.Resources;


import java.time.LocalDateTime;
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
    
    public List<Service> execute(TypedQuery query) {
        if(!query.getResultList().isEmpty()) {
            List<Service> services = query.getResultList();
            return services;
        } else {
            List<Service> services = new ArrayList<>();
            return services;
        }
    }

    public void persistService(Service service){
        em.persist(service);
        em.flush();
    }
    
    public void cleanUpServices(){
        TypedQuery<Service> query = em.createQuery("DELETE FROM Service WHERE removeDate<:now", Service.class);
        query.setParameter("now", LocalDateTime.now());
        query.executeUpdate();
    }
    
    public List<Service> getServiceList(String serviceType, String league){
        TypedQuery<Service> query = em.createQuery("SELECT s FROM Service s WHERE  s.serviceType='" + serviceType + "' AND s.league='" + league + "'", Service.class);
        return execute(query);
    }
}
