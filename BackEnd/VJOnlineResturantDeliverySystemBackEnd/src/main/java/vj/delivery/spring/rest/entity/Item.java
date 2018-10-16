package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private String itemImage;
    private String itemName;
    private double itemprice;
    private String itemModel;
    private String discription;
    private Date Date;
    private Time time;

    public Item() {
    }

    public Item(String itemImage, String itemName, double itemprice, String itemModel, String discription, java.util.Date date, Time time) {
        this.setItemImage(itemImage);
        this.setItemName(itemName);
        this.setItemprice(itemprice);
        this.setItemModel(itemModel);
        this.setDiscription(discription);
        setDate(date);
        this.setTime(time);
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemImage='" + itemImage + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemprice=" + itemprice +
                ", itemModel='" + itemModel + '\'' +
                ", discription='" + discription + '\'' +
                ", Date=" + Date +
                ", time=" + time +
                '}';
    }
}
