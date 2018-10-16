package vj.delivery.spring.rest.dto;

public class CustomerDto {
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

    public CustomerDto() {
    }

    public CustomerDto(int id, String email, String password, String redowPasswod, String teleponeNO, String fullName, String distriac, String address, String youmanssge, String customerImage) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setRedowPasswod(redowPasswod);
        this.setTeleponeNO(teleponeNO);
        this.setFullName(fullName);
        this.setDistriac(distriac);
        this.setAddress(address);
        this.setYoumanssge(youmanssge);
        this.setCustomerImage(customerImage);
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
        return "CustomerDto{" +
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
