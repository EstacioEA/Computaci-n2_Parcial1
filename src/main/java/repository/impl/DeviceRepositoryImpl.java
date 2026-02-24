package repository.impl;

import model.Device;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DeviceRepositoryImpl {

    private ArrayList<Device> devices;

    public DeviceRepositoryImpl() {
        this.devices = new ArrayList<>();
    }


}
