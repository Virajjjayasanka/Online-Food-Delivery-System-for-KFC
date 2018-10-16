package vj.delivery.spring.rest.service;

public interface AdminLoginService {

    boolean canAuthenticate(String gmail, String password);
}
