package vj.delivery.spring.rest.dto;

public class SelectedItemDto {

    private int selectItemID;
    private String customerGmail;
    private String itemModel;
    private String itemName;
    private String ImageURL;
    private double price;
    private int qty;
    private double subTotal;


    public SelectedItemDto() {
    }

    public SelectedItemDto(int selectItemID, String customerGmail, String itemModel, String itemName, String imageURL, double price, int qty, double subTotal) {
        this.setSelectItemID(selectItemID);
        this.setCustomerGmail(customerGmail);
        this.setItemModel(itemModel);
        this.setItemName(itemName);
        setImageURL(imageURL);
        this.setPrice(price);
        this.setQty(qty);
        this.setSubTotal(subTotal);
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
        return "SelectedItemDto{" +
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
