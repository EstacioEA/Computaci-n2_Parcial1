package repository.impl;

import jakarta.annotation.PostConstruct;
import model.Device;
import org.springframework.stereotype.Repository;
import repository.DeviceRepository;

import java.util.ArrayList;

@Repository
public class DeviceRepositoryImpl implements DeviceRepository {

    private ArrayList<Device> devices;

    public DeviceRepositoryImpl() {
        this.devices = new ArrayList<>();
    }


    @Override
    public void addMeasurementToDevice(Device device) {

    }

    @PostConstruct
    @Override
    public void init() {
        Device device1 = new Device(1,"d1","DEV-123","sensor",200,50,2000,200,"celsius");
        devices.add(device1);
        System.out.println("Device repository initialized with: "+devices.size()+" devices");
    }

    @Override
    public boolean exists(int deviceId) {
        for (Device device : devices) {
            if (device.getId() == deviceId){
                return true;
            }
        }
        return false;
    }

    @Override
    public Device getDevice(int deviceId) {
        if (exists(deviceId)){
            for (Device device : devices) {
                if (device.getId() == deviceId){
                    return device;
                }
            }
        }
        return null;
    }
}
