public class BakeryPart1 {

   public void main(String[] args) {
      // BakedItem class

      // Cookie class
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      System.out.println(c.price());

      // Pie class
      Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
            "flour", "sugar", "apples", "cinnamon",
            "butter", "baking soda", "salt");
      Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
            "flour", "sugar", "lime juice", "lemon juice",
            "graham crackers", "butter", "baking soda", "salt");

      // Cake class
      Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
            "flour", "sugar", "cocoa powder", "vanilla", "eggs",
            "butter", "baking soda", "baking powder", "salt");
      Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
            "flour", "sugar", "cocoa powder", "food coloring",
            "eggs", "butter", "baking soda", "baking powder",
            "salt");

      // WeddingCake class
      WeddingCake c3 = new WeddingCake("3-Layer/3-Tier", "Vanilla", 1, 3, 3,
            "flour", "sugar", "buttermilk", "coffee",
            "eggs", "butter", "baking soda", "baking powder",
            "salt");

   }
}