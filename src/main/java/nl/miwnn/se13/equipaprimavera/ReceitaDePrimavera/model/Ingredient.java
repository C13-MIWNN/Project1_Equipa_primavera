package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Mirjam Schmitz
 * <p>
 * Describes ingredients by name and amount
 **/
@Entity
public class Ingredient {
    @Id @GeneratedValue
    private Long ingredientId;
    @Column(unique = true)
    private String nameIngredient;
    @ManyToOne
    private MeasurementUnit measurementUnit;
    private int amountOfIngredient;

    public Ingredient(String nameIngredient, MeasurementUnit measuringUnit, int amountOfIngredient) {
        this.nameIngredient = nameIngredient;
        this.measurementUnit = measuringUnit;
        this.amountOfIngredient = amountOfIngredient;
    }

    public Ingredient() {
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getNameIngredient() {

        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measuringUnit) {
        this.measurementUnit = measuringUnit;
    }

    public int getAmountOfIngredient() {
        return amountOfIngredient;
    }

    public void setAmountOfIngredient(int amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }
}
