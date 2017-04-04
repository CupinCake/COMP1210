public abstract class BakedItem {

   protected String name;
   protected String flavor;
   protected int quantity;
   protected String[] ingredients;
   protected static int count = 0;

   public BakedItem(String nameIn, String flavorIn, int quantityIn, 
                                             String ... ingredientsIn) {
      name = nameIn;
      flavor = flavorIn;
      quantity = quantityIn;
      ingredients = ingredientsIn;
   }

   public String getName() {
      return name;
   }

   public void setName(String nameIn) {
      this.name = nameIn;
   }

   public String getFlavor() {
      return flavor;
   }

   public void setFlavor(String flavorIn) {
      this.flavor = flavorIn;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantityIn) {
      this.quantity = quantityIn;
   }

   public String[] getIngredients() {
      return ingredients;
   }

   public void setIngredients(String[] ingredientsIn) {
      this.ingredients = ingredientsIn;
   }

   public static int getCount() {
      return count;
   }

   public static void resetCount() {
      BakedItem.count = 0;
   }

   /* TODO: 4/4/2017 fix price() so that its formatted right and the 
   list of ingredients.*/
   public final String toString() {
      String result = this.getClass().toString().substring(6) 
         + ": " + name + " - " + flavor + "\t" + quantity + "\tPrice: " 
         + price() + "\n" + "(Ingredients: " + ingredients + ")";
      return result;
   }

   public abstract double price();
}