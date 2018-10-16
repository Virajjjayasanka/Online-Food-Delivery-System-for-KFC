package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
@Entity
public class OnlineRider {
    @Id
    private String riderName;
    private String online;
    private Date date;
    private Time time;

    public OnlineRider() {
    }

    public OnlineRider(String riderName, String online, Date date, Time time) {
        this.setRiderName(riderName);
        this.setOnline(online);
        this.setDate(date);
        this.setTime(time);
    }


    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OnlineRider{" +
                "riderName='" + riderName + '\'' +
                ", online='" + online + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
