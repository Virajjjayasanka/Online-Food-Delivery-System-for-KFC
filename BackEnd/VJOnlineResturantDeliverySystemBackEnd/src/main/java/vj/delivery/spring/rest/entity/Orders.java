package vj.delivery.spring.rest.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oderID;
    private Date date;
    private double total;
    private String caption;
    private String riderName;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Customer customer;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderDetail> OrderDetail;

    public Orders() {
    }

    public Orders(int oderID, Date date, double total, String caption, String riderName) {
        this.setOderID(oderID);
        this.setDate(date);
        this.setTotal(total);
        this.setCaption(caption);
        this.setRiderName(riderName);
    }

    public Orders(int oderID, Date date, double total, String caption, String riderName, Customer customer) {
        this.setOderID(oderID);
        this.setDate(date);
        this.setTotal(total);
        this.setCaption(caption);
        this.setRiderName(riderName);
        this.setCustomer(customer);
    }

    public Orders(int oderID, Date date, double total, String caption, String riderName, Customer customer, List<vj.delivery.spring.rest.entity.OrderDetail> orderDetail) {
        this.setOderID(oderID);
        this.setDate(date);
        this.setTotal(total);
        this.setCaption(caption);
        this.setRiderName(riderName);
        this.setCustomer(customer);
        setOrderDetail(orderDetail);
    }


    public int getOderID() {
        return oderID;
    }

    public void setOderID(int oderID) {
        this.oderID = oderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<vj.delivery.spring.rest.entity.OrderDetail> getOrderDetail() {
        return OrderDetail;
    }

    public void setOrderDetail(List<vj.delivery.spring.rest.entity.OrderDetail> orderDetail) {
        OrderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oderID=" + oderID +
                ", date=" + date +
                ", total=" + total +
                ", caption='" + caption + '\'' +
                ", riderName='" + riderName + '\'' +
                ", customer=" + customer +
                ", OrderDetail=" + OrderDetail +
                '}';
    }
}
