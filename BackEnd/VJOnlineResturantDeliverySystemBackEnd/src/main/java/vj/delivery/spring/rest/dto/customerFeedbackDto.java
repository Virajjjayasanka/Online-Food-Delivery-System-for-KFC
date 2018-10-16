package vj.delivery.spring.rest.dto;

import java.util.Date;

public class customerFeedbackDto {

    private int FID;
    private String Gmail;
    private String CustomerName;
    private int TeleponeNo;
    private String UverFeedBack;
    private String Suggesant;
    private Date Date;

    public customerFeedbackDto() {
    }

    public customerFeedbackDto(int FID, String gmail, String customerName, int teleponeNo, String uverFeedBack, String suggesant, java.util.Date date) {
        this.setFID(FID);
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
        return "customerFeedbackDto{" +
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
