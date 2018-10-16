package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SelectItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int selectItemID;
    private String customerGmail;
    private String itemModel;
    private String itemName;
    private String ImageURL;
    private double price;
    private int qty;
    private double subTotal;

    public SelectItem() {
    }

    public SelectItem(String customerGmail, String itemModel, String itemName, String imageURL, double price, int qty, double subTotal) {
        this.setCustomerGmail(customerGmail);
        this.setItemModel(itemModel);
        this.setItemName(itemName);
        setImageURL(imageURL);
        this.setPrice(price);
        this.setQty(qty);
        this.setSubTotal(subTotal);
    }

    public SelectItem(int selectItemID, String customerGmail, String itemModel, String itemName, String imageURL, double price, int qty, double subTotal) {
        this.selectItemID = selectItemID;
        this.customerGmail = customerGmail;
        this.itemModel = itemModel;
        this.itemName = itemName;
        ImageURL = imageURL;
        this.price = price;
        this.qty = qty;
        this.subTotal = subTotal;
    }

    public int getSelectItemID() {
        return selectItemID;
    }

    public void setSelectItemID(int selectItemID) {
        this.selectItemID = selectItemID;
    }

    public String getCustomerGmail() {
        return customerGmail;
    }

    public void setCustomerGmail(String customerGmail) {
        this.customerGmail = customerGmail;
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
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
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

    @Override
    public String toString() {
        return "SelectItem{" +
                "selectItemID=" + selectItemID +
                ", customerGmail='" + customerGmail + '\'' +
                ", itemModel='" + itemModel + '\'' +
                ", itemName='" + itemName + '\'' +
                ", ImageURL='" + ImageURL + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                '}';
    }
}
