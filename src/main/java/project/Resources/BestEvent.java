package project.Resources;

import javax.ejb.EJB;
import project.entities.Service;

public class BestEvent {

    @EJB
    DBManager dbManager;
    
    public BestEvent() {
        Service service = new Service();
        service.setTitle("Best");
        service.setServiceType("Boosting");
        service.setInGameName("BestMan");
        dbManager.persistService(service);
    }
}
