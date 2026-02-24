package repository;

import model.Measurement;

import java.util.ArrayList;

public interface MeasurementRepository {
    void addMeasurement(Measurement measurement);
    void init();
}
