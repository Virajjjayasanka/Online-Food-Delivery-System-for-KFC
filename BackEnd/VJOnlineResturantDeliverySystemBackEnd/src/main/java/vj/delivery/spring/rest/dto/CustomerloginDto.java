package vj.delivery.spring.rest.dto;

public class CustomerloginDto {

    private String gmail;
    private String password;

    public CustomerloginDto() {
    }

    public CustomerloginDto(String gmail, String password) {
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
        return "CustomerloginDto{" +
                "gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
