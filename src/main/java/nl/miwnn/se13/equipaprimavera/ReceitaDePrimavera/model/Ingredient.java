package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Mirjam Schmitz
 * <p>
 * Describes ingredients by name and amount
 **/
@Entity
public class Ingredient {
    @Id @GeneratedValue
    private Long ingredientId;
    private String nameIngredient;
    private String measuringUnit;
    private int amountOfIngredient;

    public Ingredient(String nameIngredient, String measuringUnit, int amountOfIngredient) {
        this.nameIngredient = nameIngredient;
        this.measuringUnit = measuringUnit;
        this.amountOfIngredient = amountOfIngredient;
    }

    public Ingredient() {
    }

    public String getNameIngredient() {

        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public int getAmountOfIngredient() {
        return amountOfIngredient;
    }

    public void setAmountOfIngredient(int amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }
}
