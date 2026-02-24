package service.impl;

import model.Device;
import model.Measurement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.DeviceRepository;
import repository.MeasurementRepository;
import service.MeasurementService;

import java.util.ArrayList;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private MeasurementRepository measurementRepository;
    private DeviceRepository deviceRepository;

    public MeasurementServiceImpl(@Qualifier("measurementRepositoryImpl") MeasurementRepository measurementRepository,
                                  @Qualifier("deviceRepositoryImpl") DeviceRepository deviceRepository) {
        this.measurementRepository = measurementRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void addMeasurement(Measurement measurement) {
        if (validateMeasurement(measurement)) {
            measurementRepository.addMeasurement(measurement);
        }
    }

    @Override
    public boolean validateMeasurement(Measurement measurement) {
        if (deviceRepository.exists(measurement.getDeviceId())){
            Device device = deviceRepository.getDevice(measurement.getDeviceId());
            if (validateRange(measurement,device)){
                if (validateTimestamp(measurement,device)){
                    if (validateTimestampPeriod(measurement,device)){

                    }
                }
            }
            return false;
        }
        return false;
    }

    private boolean validateTimestampPeriod(Measurement measurement, Device device) {
        double period = device.getSamplingPeriod();
        double tolerance = device.getTimeTolerance();
        if ((measurement.getTimestamp() % period) < tolerance) {
            return true;
        }
        return false;
    }

    private boolean validateTimestamp(Measurement measurement, Device device) {
        ArrayList<Measurement> deviceMeasurement = device.getMeasurements();
        for (Measurement m : deviceMeasurement) {
            if (m.getTimestamp() == measurement.getTimestamp()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRange(Measurement measurement, Device device) {
        if (measurement.getValue()>device.getMinValue()&&measurement.getValue()<device.getMaxValue()){
            return true;
        }
        return false;
    }
}
