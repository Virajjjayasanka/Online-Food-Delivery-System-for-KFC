package vj.delivery.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Riderlogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int  rideid;
    private String ridername;
    private String address;
    private int teleponeNo;
    private String username;
    private String password;
    private String imageUrl;

    public Riderlogin() {
    }

    public Riderlogin(int rideid, String ridername, String address, int teleponeNo, String username, String password, String imageUrl) {
        this.setRideid(rideid);
        this.setRidername(ridername);
        this.setAddress(address);
        this.setTeleponeNo(teleponeNo);
        this.setUsername(username);
        this.setPassword(password);
        this.setImageUrl(imageUrl);
    }

    public int getRideid() {
        return rideid;
    }

    public void setRideid(int rideid) {
        this.rideid = rideid;
    }

    public String getRidername() {
        return ridername;
    }

    public void setRidername(String ridername) {
        this.ridername = ridername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTeleponeNo() {
        return teleponeNo;
    }

    public void setTeleponeNo(int teleponeNo) {
        this.teleponeNo = teleponeNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Riderlogin{" +
                "rideid=" + rideid +
                ", ridername='" + ridername + '\'' +
                ", address='" + address + '\'' +
                ", teleponeNo=" + teleponeNo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
