package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class RiderGetOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int riderGetOrderID;
    private int oderID;
    private int customerID;
    private String riderName;
    private double total;
    private double payament;
    private String paymentModel;
    private Date date;


    public RiderGetOrder() {
    }

    public RiderGetOrder(int oderID, int customerID, String riderName, double total, double payament, String paymentModel, Date date) {
        this.setOderID(oderID);
        this.setCustomerID(customerID);
        this.setRiderName(riderName);
        this.setTotal(total);
        this.setPayament(payament);
        this.setPaymentModel(paymentModel);
        this.setDate(date);
    }


    public int getRiderGetOrderID() {
        return riderGetOrderID;
    }

    public void setRiderGetOrderID(int riderGetOrderID) {
        this.riderGetOrderID = riderGetOrderID;
    }

    public int getOderID() {
        return oderID;
    }

    public void setOderID(int oderID) {
        this.oderID = oderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPayament() {
        return payament;
    }

    public void setPayament(double payament) {
        this.payament = payament;
    }

    public String getPaymentModel() {
        return paymentModel;
    }

    public void setPaymentModel(String paymentModel) {
        this.paymentModel = paymentModel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RiderGetOrder{" +
                "riderGetOrderID=" + riderGetOrderID +
                ", oderID=" + oderID +
                ", customerID=" + customerID +
                ", riderName='" + riderName + '\'' +
                ", total=" + total +
                ", payament=" + payament +
                ", paymentModel='" + paymentModel + '\'' +
                ", date=" + date +
                '}';
    }
}
