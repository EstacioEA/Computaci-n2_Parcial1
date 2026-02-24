package service.impl;

import model.Measurement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.MeasurementRepository;
import service.MeasurementService;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private MeasurementRepository measurementRepository;

    public MeasurementServiceImpl(@Qualifier("measurementRepositoryImpl") MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public void addMeasurement(Measurement measurement) {

    }

    @Override
    public boolean validateMeasurement(Measurement measurement) {
        return false;
    }
}
