package repository;

import model.Device;

public interface DeviceRepository {
    void addMeasurementToDevice(Device device);
    void init();
    boolean exists(int deviceId);
    Device getDevice(int deviceId);
}
