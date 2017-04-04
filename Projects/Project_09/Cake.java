public class Cake extends BakedItem {

   protected int layers;
   public static final double BASE_RATE = 8;

   public Cake(String nameIn, String flavorIn, int quantityIn, 
                        int layersIn, String ... ingredientsIn) {
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      layers = layersIn;
   }

   public int getLayers() {
      return layers;
   }

   public void setLayers(int layersIn) {
      this.layers = layersIn;
   }

   public double price() {
      return (BASE_RATE * layers) * quantity;
   }
}