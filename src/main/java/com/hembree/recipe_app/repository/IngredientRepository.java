package com.hembree.recipe_app.repository;


import com.hembree.recipe_app.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}