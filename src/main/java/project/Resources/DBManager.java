package project.Resources;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Emil on 2017-12-08.
 */
@Stateless(name = "DBManager")
public class DBManager {

    @PersistenceContext(name = "dbmanager")
    EntityManager em;


}
