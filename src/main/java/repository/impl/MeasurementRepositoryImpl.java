package repository.impl;

import model.Measurement;

import java.util.ArrayList;

public class MeasurementRepositoryImpl {

    private ArrayList<Measurement> measurements;

    public MeasurementRepositoryImpl() {
        this.measurements = new ArrayList<>();
    }
}
