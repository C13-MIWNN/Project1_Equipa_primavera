package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera.model;

import jakarta.persistence.*;

import java.util.Collection;
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
    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredient;

    public Ingredient(String nameIngredient, MeasurementUnit measuringUnit) {
        this.nameIngredient = nameIngredient;
        this.measurementUnit = measuringUnit;
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

    public List<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(List<RecipeIngredient> recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }
}
