package vj.delivery.spring.rest.service;
import vj.delivery.spring.rest.dto.RiderLoginDto;

import java.util.ArrayList;

public interface RiderLoginService {

    boolean canAuthenticate(String username, String password);

    public ArrayList<RiderLoginDto> getAllRiders();

    public RiderLoginDto getRiders(int id);

    public boolean deleteRiders(int id);

    public boolean saveRiders(RiderLoginDto rider);

    public ArrayList<RiderLoginDto> findByEmailAddress(String username);

    public   long  getTotalRiders();
}
