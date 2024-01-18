package com.prashant.controller;

import com.prashant.model.Recipe;
import com.prashant.model.User;
import com.prashant.service.RecipeService;
import com.prashant.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/recipes")
public class RecipeController {
    private RecipeService recipeService;
    private UserService userService;
    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @PostMapping("/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) throws Exception {
        User user = userService.findUserById(userId);
        Recipe createdRecipe = recipeService.createRecipe(recipe, user);

        return createdRecipe;
    }

    @GetMapping()
    public List<Recipe> getAllRecipe() throws Exception {

        List<Recipe> recipes = recipeService.findAllRecipe();

        return recipes;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);

        return "Recipe deleted successfully";
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe, id);

        return updatedRecipe;
    }

    @PutMapping("/{id}/like/user/{userId}")
    public Recipe likeRecipe(@PathVariable Long userId, @PathVariable Long id) throws Exception {
        User user = userService.findUserById(userId);
        Recipe updatedRecipe = recipeService.likeRecipe(id, user);

        return updatedRecipe;
    }
}
