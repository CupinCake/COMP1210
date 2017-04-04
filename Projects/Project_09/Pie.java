public class Pie extends BakedItem {

   private double crustCost;
   public static final double BASE_RATE = 12.0;

   public Pie(String nameIn, String flavorIn, int quantityIn, 
               double crustCostIn, String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      crustCost = crustCostIn;
   }

   public double getCrustCost() {
      return crustCost;
   }

   public void setCrustCost(double crustCostIn) {
      this.crustCost = crustCostIn;
   }

   public double price() {
      return (BASE_RATE + crustCost) * quantity;
   }
}