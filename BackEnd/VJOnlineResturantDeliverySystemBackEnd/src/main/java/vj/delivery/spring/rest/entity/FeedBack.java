package vj.delivery.spring.rest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(name = "CustomeReDelatAdd" ,query="select * from feedBack where Gmail  = ?",resultClass = FeedBack.class)
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int FID;
    private String Gmail;
    private String CustomerName;
    private int TeleponeNo;
    private String UverFeedBack;
    private String Suggesant;
    private Date Date;

    public FeedBack() {
    }

    public FeedBack(String gmail, String customerName, int teleponeNo, String uverFeedBack, String suggesant, java.util.Date date) {
        setGmail(gmail);
        setCustomerName(customerName);
        setTeleponeNo(teleponeNo);
        setUverFeedBack(uverFeedBack);
        setSuggesant(suggesant);
        setDate(date);
    }

    public int getFID() {
        return FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getTeleponeNo() {
        return TeleponeNo;
    }

    public void setTeleponeNo(int teleponeNo) {
        TeleponeNo = teleponeNo;
    }

    public String getUverFeedBack() {
        return UverFeedBack;
    }

    public void setUverFeedBack(String uverFeedBack) {
        UverFeedBack = uverFeedBack;
    }

    public String getSuggesant() {
        return Suggesant;
    }

    public void setSuggesant(String suggesant) {
        Suggesant = suggesant;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "FID=" + FID +
                ", Gmail='" + Gmail + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", TeleponeNo=" + TeleponeNo +
                ", UverFeedBack='" + UverFeedBack + '\'' +
                ", Suggesant='" + Suggesant + '\'' +
                ", Date=" + Date +
                '}';
    }
}
