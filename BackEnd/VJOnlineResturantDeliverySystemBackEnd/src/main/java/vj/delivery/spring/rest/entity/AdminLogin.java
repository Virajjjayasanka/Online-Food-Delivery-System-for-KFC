package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogin {
    @Id
    private String gmail;
    private String password;

    public AdminLogin() {
    }

    public AdminLogin(String gmail, String password) {
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
        return "AdminLogin{" +
                "gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
