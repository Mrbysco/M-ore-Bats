package com.svennieke.MOreBats.plugins.jei;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin{
	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
		
	}
	
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();

	}
	
	@Override
	public void registerIngredients(IModIngredientRegistration registry) {

	}
	
	@Override
	public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {

	}
}
