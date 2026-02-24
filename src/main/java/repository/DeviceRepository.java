package repository;

import model.Device;

public interface DeviceRepository {
    void addMeasurementToDevice(Device device);
    void init();
}
