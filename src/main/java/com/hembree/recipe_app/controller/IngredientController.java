package com.hembree.recipe_app.controller;


import com.hembree.recipe_app.model.Ingredient;
import com.hembree.recipe_app.repository.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    
    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() { return ingredientRepository.findAll(); }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found"));
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) { return ingredientRepository.save(ingredient); }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        if(!ingredientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient not found");
        }
        ingredientRepository.deleteById(id);
    }

}
