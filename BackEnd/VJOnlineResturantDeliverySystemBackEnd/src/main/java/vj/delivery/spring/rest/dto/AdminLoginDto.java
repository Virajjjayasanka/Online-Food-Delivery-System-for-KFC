package vj.delivery.spring.rest.dto;

public class AdminLoginDto {

    private String gmail;
    private String password;

    public AdminLoginDto() {
    }

    public AdminLoginDto(String gmail, String password) {
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
        return "AdminLoginDto{" +
                "gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
