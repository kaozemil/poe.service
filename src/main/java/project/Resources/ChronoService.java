package project.Resources;

import project.entities.Service;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Singleton;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Emil on 2018-01-02.
 */
@Singleton
public class ChronoService {

    @EJB
    DBManager dbManager;

    @Resource
    private TimerService timerService;

    private final Logger log = Logger.getLogger(ChronoService.class.getName());

    private void createTimer() {
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.second("30").minute("*/5").hour("*");
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setPersistent(false);
        timerService.createCalendarTimer(scheduleExpression, timerConfig);
    }

    @Timeout
    public void timerTimeout() {

    }


    @Schedule(minute = "*/1", hour="*", persistent = false)
    public void runEveryMinute() {
        log.log(Level.INFO,
                "running every minute .. now it's: " + new Date().toString());
        Service service = new Service();
        service.setInGameName("Timer");
        service.setServiceType("Boosting");
        service.setTitle("LULtimed");

        dbManager.persistService(service);

    }

}
