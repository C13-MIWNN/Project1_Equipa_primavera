package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Bram van Ham
 * Purpose for the class
 **/
@Entity
public class IngredientRow {

    @Id
    @GeneratedValue
    private Long ingredientRowId;

    private Integer amountOfIngredient = null;
    @ManyToOne
    private MeasurementUnit measurementUnit = null;
    private String nameOfIngredient = null;

    @ManyToOne
    private Recipe recipe;

    public IngredientRow() {
        super();
    }

    public Integer getAmountOfIngredient() {
        return amountOfIngredient;
    }

    public void setAmountOfIngredient(Integer amountOfIngredient) {
        this.amountOfIngredient = amountOfIngredient;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    public Long getIngredientRowId() {
        return ingredientRowId;
    }

    public void setIngredientRowId(Long ingredientRowId) {
        this.ingredientRowId = ingredientRowId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
