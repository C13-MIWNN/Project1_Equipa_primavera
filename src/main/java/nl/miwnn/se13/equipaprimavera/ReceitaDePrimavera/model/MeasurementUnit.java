package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Entity
public class MeasurementUnit {
    @Id @GeneratedValue
    private Long measurementUnitId;
    private String nameOfMeasurement;

    public MeasurementUnit(String nameOfMeasurement) {
        this.nameOfMeasurement = nameOfMeasurement;
    }
    public MeasurementUnit() {

    }

    public Long getMeasurementUnitId() {
        return measurementUnitId;
    }

    public void setMeasurementUnitId(Long measurementUnitId) {
        this.measurementUnitId = measurementUnitId;
    }

    public String getNameOfMeasurement() {
        return nameOfMeasurement;
    }

    public void setNameOfMeasurement(String nameOfMeasurement) {
        this.nameOfMeasurement = nameOfMeasurement;
    }
}
