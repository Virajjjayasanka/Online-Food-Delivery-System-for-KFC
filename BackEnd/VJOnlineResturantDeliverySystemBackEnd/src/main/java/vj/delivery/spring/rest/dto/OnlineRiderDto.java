package vj.delivery.spring.rest.dto;

import java.sql.Time;
import java.util.Date;

public class OnlineRiderDto {

    private String riderName;
    private String online;
    private Date date;
    private Time time;

    public OnlineRiderDto() {
    }

    public OnlineRiderDto(String riderName, String online, Date date, Time time) {
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
        return "OnlineRiderDto{" +
                "riderName='" + riderName + '\'' +
                ", online='" + online + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
