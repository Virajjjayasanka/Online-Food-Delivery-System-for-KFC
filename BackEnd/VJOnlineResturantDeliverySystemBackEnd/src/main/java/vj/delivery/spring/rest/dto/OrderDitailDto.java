package vj.delivery.spring.rest.dto;

import vj.delivery.spring.rest.entity.Orders;

public class OrderDitailDto {

    private int orderDitailDtoID;
    private String itemModel;
    private String itemName;
    private String imageURL;
    private String customerEmail;
    private double price;
    private int qty;
    private double subTotal;
    private Orders orders;

    public OrderDitailDto() {
    }

    public OrderDitailDto(int orderDitailDtoID, String itemModel, String itemName, String imageURL, String customerEmail, double price, int qty, double subTotal) {
        this.orderDitailDtoID = orderDitailDtoID;
        this.itemModel = itemModel;
        this.itemName = itemName;
        this.imageURL = imageURL;
        this.customerEmail = customerEmail;
        this.price = price;
        this.qty = qty;
        this.subTotal = subTotal;
    }

    public OrderDitailDto(int orderDitailDtoID, String itemModel, String itemName, String imageURL, String customerEmail, double price, int qty, double subTotal, Orders orders) {
        this.orderDitailDtoID = orderDitailDtoID;
        this.itemModel = itemModel;
        this.itemName = itemName;
        this.imageURL = imageURL;
        this.customerEmail = customerEmail;
        this.price = price;
        this.qty = qty;
        this.subTotal = subTotal;
        this.orders = orders;
    }

    public int getOrderDitailDtoID() {
        return orderDitailDtoID;
    }

    public void setOrderDitailDtoID(int orderDitailDtoID) {
        this.orderDitailDtoID = orderDitailDtoID;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderDitailDto{" +
                "orderDitailDtoID=" + orderDitailDtoID +
                ", itemModel='" + itemModel + '\'' +
                ", itemName='" + itemName + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                ", orders=" + orders +
                '}';
    }
}
