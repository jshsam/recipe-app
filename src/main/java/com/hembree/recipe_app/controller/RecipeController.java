package com.hembree.recipe_app.controller;


import com.hembree.recipe_app.model.Recipe;
import com.hembree.recipe_app.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) { this.recipeRepository = recipeRepository; }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
    }

    @PostMapping
    public Recipe createRecipes(@RequestBody Recipe recipe) { return recipeRepository.save(recipe); }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        if(!recipeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
        }
        recipeRepository.deleteById(id);
    }

}
