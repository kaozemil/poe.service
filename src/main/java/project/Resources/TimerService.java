package project.Resources;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Singleton;

@Singleton
@Startup
public class TimerService {
    
    @EJB
    DBManager dbManager;
    @Schedule(second="*/15", minute="*", hour="*", persistent=false)
    public void execute() {
        dbManager.cleanUpServices();
    }
}
