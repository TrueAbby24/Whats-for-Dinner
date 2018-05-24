package com.infs3202.wfd.whatsfordinner;

public class SearchTerms {
	private final static String LINE_SEPARATOR = System.getProperty(
	            "line.separator");
	public final int MAXINGREDIENTS = 10;
	private String[] ingredients = new String[MAXINGREDIENTS];
//		^all ingr saved in lower case
	private int ingredientCount; 
	public enum Type { NAME, INGREDIENT };
	private Type searchType;
	private String name;
	
	
	/**
	 * Sets initial state of object.
	 */
	public void resetTerms(Type s){
		this.ingredientCount = 0;
		this.searchType = s;
		this.name = "chocolate cake";
//		System.out.println("reset done :)");
	}
	
	/**
	 *Creates a new SearchTerms object and initialises state. 
	 */
	public SearchTerms(Type s) {
		this.resetTerms(s);
//		System.out.format("happiness is %s", this.name);
	}
	
	/**
	 * Checks if an ingredient has already been added to the items that are 
	 *   going to be searched for.
	 * @param ingredient
	 * 		Name of the ingredient being tested.
	 * @return
	 * 		Method returns true if a duplicate and false otherwise.
	 */
	private boolean findDuplicate(String ingredient) {
		for (int i = 0; i < this.ingredientCount; i++){
			if (ingredient.equals(this.ingredients[i])) {
//				System.out.println("duplicate won't add again");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds ingredient to the list of ingredients being searched for.
	 * @param ingredient
	 */
	public void addIngredient(String ingredient) {
		if (this.searchType == Type.INGREDIENT){
	//		save as lower case
			ingredient = ingredient.toLowerCase();
//			System.out.println("ingr: " + ingredient);
	//		check space for new ingr
			if (this.ingredientCount == MAXINGREDIENTS) {
				System.out.println("ingredients full");
				return;
			}
	//		check duplicate
			if(this.findDuplicate(ingredient)){
				return;
			}
	//		add to ingr & inc ingCount
			this.ingredients[this.ingredientCount] = ingredient;
			this.ingredientCount++;
		} else {
			System.out.println("incorrect type term");
		}
		
	}
	
	/**
	 * Finds number of ingredient in list of ingredients.
	 * 
	 * @param ingredient
	 * @return ingredient number of given ingredient or -1 if ingredient is not 
	 * 		found.
	 */
	private int findIngredient(final String ingredient) {
		for (int i = 0;  i < this.ingredientCount; i++) {
			if (ingredient.equals(this.ingredients[i])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Removes ingredient from the search terms.
	 * @param ingredient	Ingredient you want to remove.
	 */
	public void removeIngredient(String ingredient) {
		int index = this.findIngredient(ingredient);
		if (index > -1) {
			for (int i = index;i < this.ingredientCount-1; i++) {
				this.ingredients[i] = this.ingredients[i+1];
			}
			this.ingredientCount--;
		}
	}
	
	/**
	 * Swops two ingredients out, replaces old ingredient with a new one.
	 *   DOES NOT change order of ingredients.
	 * @param old		Ingredient that you want to replace/remove. 
	 * @param newIngr	New ingredient that you want to search for.
	 */
	public void swopIngredients(String old, String newIngr) {
		//check duplicate
		boolean duplicate = this.findDuplicate(newIngr);
		if (duplicate) {
			this.removeIngredient(old);			
		} else {
			//replace old
			int index = this.findIngredient(old);
			this.ingredients[index] = newIngr;
		}
	}
	
	/**
	 * Sets name of a recipe you want to search for.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gives name of recipe searched for.
	 * @return	Name of recipe.
	 */
	public String getName() {
		return new String(this.name);
	}
	
	/**
	 * Tells what ingredients have been searched for.
	 * @return	list of ingredients being searched for.
	 */
	public String[] getIngredients() {
		String[] result = new String[this.ingredientCount];
		for (int i = 0; i < result.length; i++) {
			result[i] = new String(this.ingredients[i]);
		}
		return result;
	}
	
	
	/**
	 * Returns string representation of object.
	 */
	public String toString() {
		String result = "----Search Terms----" + LINE_SEPARATOR + "Type: ";
		result += (this.searchType == Type.NAME ? "name" : "ingredient");
		result += LINE_SEPARATOR;
		if (this.searchType == Type.NAME) {
			result += "Name: " + this.name +  LINE_SEPARATOR;
		}else {
			for (int i = 0; i < this.ingredientCount; i++){
				result += (i+1) + "=>" + this.ingredients[i] + LINE_SEPARATOR;
			}
		}
		result += "--------------------";
		return result;		
	}
}

