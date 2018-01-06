package project.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import project.service.LocalDateTimeAttributeConverter;
/**
 * Created by Emil on 2018-01-02.
 */
@Entity
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String serviceType;
    private String inGameName;
    private String league;
    @Column
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime removeDate;

    public LocalDateTime getremoveDate() {
        return removeDate;
    }

    public void setremoveDate(LocalDateTime date) {
        this.removeDate = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInGameName() {
        return inGameName;
    }

    public void setInGameName(String inGameName) {
        this.inGameName = inGameName;
    }
    
    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }
}
