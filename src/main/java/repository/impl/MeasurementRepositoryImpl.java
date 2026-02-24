package repository.impl;

import model.Measurement;
import org.springframework.stereotype.Repository;
import repository.MeasurementRepository;

import java.util.ArrayList;

@Repository
public class MeasurementRepositoryImpl implements MeasurementRepository {

    private ArrayList<Measurement> measurements;

    public MeasurementRepositoryImpl() {
        this.measurements = new ArrayList<>();
    }

    @Override
    public void addMeasurement(Measurement measurement) {

    }

    @Override
    public void init() {
        Measurement measurement1 = new Measurement(1,2000,80,1);
        Measurement measurement2 = new Measurement(2,4000,120,1);
    }
}
