public class Cookie extends BakedItem {

   public static final double BASE_RATE = 0.53;

   public Cookie(String nameIn, String flavorIn, int quantityIn, 
                                       String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
   }
   /* Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
         "flour", "sugar", "dark chocolate chips",
         "butter", "baking soda", "salt");
   */

   public double price() {
      return BASE_RATE * quantity;
   }
}