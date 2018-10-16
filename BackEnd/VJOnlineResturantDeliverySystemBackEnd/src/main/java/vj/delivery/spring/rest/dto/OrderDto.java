package vj.delivery.spring.rest.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private int oderID;
    private Date date;
    private double total;
    private String caption;
    private String riderName;
    private CustomerDto  customerDto;
    private List<OrderDitailDto> orderDitailDto;

    public OrderDto() {
    }

    public OrderDto(int oderID, Date date, double total, String caption, String riderName) {
        this.setOderID(oderID);
        this.setDate(date);
        this.setTotal(total);
        this.setCaption(caption);
        this.setRiderName(riderName);
    }

    public OrderDto(int oderID, Date date, double total, String caption, String riderName, CustomerDto customerDto) {
        this.setOderID(oderID);
        this.setDate(date);
        this.setTotal(total);
        this.setCaption(caption);
        this.setRiderName(riderName);
        this.setCustomerDto(customerDto);
    }

    public OrderDto(int oderID, Date date, double total, String caption, String riderName, CustomerDto customerDto, List<OrderDitailDto> orderDitailDto) {
        this.setOderID(oderID);
        this.setDate(date);
        this.setTotal(total);
        this.setCaption(caption);
        this.setRiderName(riderName);
        this.setCustomerDto(customerDto);
        this.setOrderDitailDto(orderDitailDto);
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

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public List<OrderDitailDto> getOrderDitailDto() {
        return orderDitailDto;
    }

    public void setOrderDitailDto(List<OrderDitailDto> orderDitailDto) {
        this.orderDitailDto = orderDitailDto;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "oderID=" + oderID +
                ", date=" + date +
                ", total=" + total +
                ", caption='" + caption + '\'' +
                ", riderName='" + riderName + '\'' +
                ", customerDto=" + customerDto +
                ", orderDitailDto=" + orderDitailDto +
                '}';
    }
}
