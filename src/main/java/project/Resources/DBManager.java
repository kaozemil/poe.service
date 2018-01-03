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


    public void createTemp(){
        
    }
    
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
    
    public void cleanServices(){
        TypedQuery<Service> query = em.createQuery("DELETE FROM Service WHERE createdDate='2'", Service.class);
        query.executeUpdate();
    }

    public List<Service> getBoosting(){
        TypedQuery<Service> query = em.createQuery("SELECT s FROM Service s WHERE  s.serviceType='Boosting'", Service.class);
        return execute(query);
    }

    public List getTeaming(){
        TypedQuery<Service> query = em.createQuery("SELECT s FROM Service s WHERE  s.serviceType='Teaming'", Service.class);
        return execute(query);
    }

    public List getCrafting(){
        TypedQuery<Service> query = em.createQuery("SELECT s FROM Service s WHERE  s.serviceType='Crafting'", Service.class);
        return execute(query);
    }

    public List getRotation(){
        TypedQuery<Service> query = em.createQuery("SELECT s FROM Service s WHERE  s.serviceType='Rotation'", Service.class);
        return execute(query);
    }
}
