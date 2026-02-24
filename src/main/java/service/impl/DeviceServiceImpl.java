package service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.DeviceRepository;

@Service
public class DeviceServiceImpl {

    private DeviceRepository deviceRepository;

    public DeviceServiceImpl(@Qualifier("deviceRepositoryImpl") DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
}
