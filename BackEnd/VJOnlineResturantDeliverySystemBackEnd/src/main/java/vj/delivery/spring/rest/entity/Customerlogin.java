package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customerlogin {

    @Id
    private String gmail;
    private String password;

    public Customerlogin() {
    }

    public Customerlogin(String gmail, String password) {
        this.setGmail(gmail);
        this.setPassword(password);
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomerloginRepostory{" +
                "gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
