package vj.delivery.spring.rest.entity;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String redowPasswod;
    private String teleponeNO;
    private String fullName;
    private String distriac;
    private String address;
    private String youmanssge;
    private String customerImage;

    public Customer() {
    }


    public Customer(int id, String email, String password, String redowPasswod, String teleponeNO, String fullName, String distriac, String address, String youmanssge, String customerImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.redowPasswod = redowPasswod;
        this.teleponeNO = teleponeNO;
        this.fullName = fullName;
        this.distriac = distriac;
        this.address = address;
        this.youmanssge = youmanssge;
        this.customerImage = customerImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedowPasswod() {
        return redowPasswod;
    }

    public void setRedowPasswod(String redowPasswod) {
        this.redowPasswod = redowPasswod;
    }

    public String getTeleponeNO() {
        return teleponeNO;
    }

    public void setTeleponeNO(String teleponeNO) {
        this.teleponeNO = teleponeNO;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDistriac() {
        return distriac;
    }

    public void setDistriac(String distriac) {
        this.distriac = distriac;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYoumanssge() {
        return youmanssge;
    }

    public void setYoumanssge(String youmanssge) {
        this.youmanssge = youmanssge;
    }

    public String getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(String customerImage) {
        this.customerImage = customerImage;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", redowPasswod='" + redowPasswod + '\'' +
                ", teleponeNO='" + teleponeNO + '\'' +
                ", fullName='" + fullName + '\'' +
                ", distriac='" + distriac + '\'' +
                ", address='" + address + '\'' +
                ", youmanssge='" + youmanssge + '\'' +
                ", customerImage='" + customerImage + '\'' +
                '}';
    }
}
