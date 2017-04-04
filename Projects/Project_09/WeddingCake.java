public class WeddingCake extends Cake {

   private int tiers;
   public static final double BASE_RATE = 15.0;

   public WeddingCake(String nameIn, String flavorIn, int quantityIn,
                   int layersIn, int tiersIn, String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, layersIn, ingredientsIn);
      tiers = tiersIn;
   }

   public int getTiers() {
      return tiers;
   }

   public void setTiers(int tiersIn) {
      this.tiers = tiersIn;
   }

   public double price() {
      return (BASE_RATE * layers * tiers) * quantity;
   }
}