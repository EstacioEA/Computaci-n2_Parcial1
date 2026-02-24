package service;

import model.Measurement;

public interface MeasurementService {
    void addMeasurement(Measurement measurement);
    boolean validateMeasurement(Measurement measurement);
}
