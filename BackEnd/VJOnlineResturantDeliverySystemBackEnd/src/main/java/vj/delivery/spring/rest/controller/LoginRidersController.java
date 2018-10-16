package vj.delivery.spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vj.delivery.spring.rest.dto.RiderLoginDto;
import vj.delivery.spring.rest.service.RiderLoginService;

@RestController
@CrossOrigin
public class LoginRidersController {

    @Autowired
    private RiderLoginService service;
    @PostMapping(value="api/v1/loginRider", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody RiderLoginDto username){
        return service.canAuthenticate(username.getUsername(), username.getPassword());
    }
}
