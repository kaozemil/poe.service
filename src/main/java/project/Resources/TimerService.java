package project.Resources;

import javax.ejb.*;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Singleton;

@Startup
@Singleton
public class TimerService {

    @Inject
    Event<BestEvent> event;

    @Schedule(hour = "*", minute = "*", second = "*/5", info = "Every 5 seconds timer", persistent = false)
    public void runEveryMinute() {
        event.fire(new BestEvent());
    }

}
