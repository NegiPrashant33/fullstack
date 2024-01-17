package com.prashant.service;

import com.prashant.model.Recipe;
import com.prashant.model.User;
import com.prashant.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl  (RecipeRepository recipeRepository) {
         this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe createRecipe(Recipe recipe, User user) {
        Recipe createdRecipe = new Recipe();
         createdRecipe.setTitle(recipe.getTitle());
         createdRecipe.setDescription(recipe.getDescription());
         createdRecipe.setUser(user);
         createdRecipe.setImage(recipe.getImage());
         createdRecipe.setCreatedAt(LocalDateTime.now());

        return recipeRepository.save(createdRecipe);
    }

    @Override
    public Recipe findRecipeById(Long id) throws Exception {
        Optional<Recipe> opt = recipeRepository.findById(id);
        if(opt.isPresent())
            return opt.get();

        throw  new Exception("Recipe with not found with id " + id);
    }

    @Override
    public void deleteRecipe(Long id) throws Exception {
        findRecipeById(id);
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
        return null;
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return null;
    }

    @Override
    public Recipe likeRecipe(Long recipeId, User user) throws Exception {
        return null;
    }
}
