package vj.delivery.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vj.delivery.spring.rest.dto.AdminLoginDto;
import vj.delivery.spring.rest.service.AdminLoginService;

@RestController
@CrossOrigin
public class AdmineLoginController {

    @Autowired
    private AdminLoginService service;

    @PostMapping(value="api/v1/Adminlogin", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody AdminLoginDto user){
        return service.canAuthenticate(user.getGmail(), user.getPassword());
    }
}
