import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 *
 */
public class CookieTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
    *
    */
   @Test public void priceTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", 6.36, c.price(), .001);
   }
   
   // Abstract Method Tests
   /**
    *
    */
   @Test public void getNameTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", "Chips Delight", c.getName());
   }
   /**
    *
    */
   @Test public void getFlavorTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", "Chocolate Chip", c.getFlavor());
   }
   /**
    *
    */
   @Test public void getQuantityTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", 12, c.getQuantity());
   }
   /**
    *
    */
   @Test public void getIngredientsTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      String result = c.getIngredients()[1];
      Assert.assertEquals("", "sugar", result);
   }
   /**
    *
    */
   @Test public void getCountTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", 1, c.getCount());
   }
   /**
    *
    */
   @Test public void setNameTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", "Chips Delight", c.getName());
      c.setName("Test");
      Assert.assertEquals("", "Test", c.getName());
   }
   /**
    *
    */
   @Test public void setFlavorTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertEquals("", "Chocolate Chip", c.getFlavor());
      c.setFlavor("Test");
      Assert.assertEquals("", "Test", c.getFlavor());
   }
   /**
    *
    */
   @Test public void setQuantityTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 1,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      Assert.assertTrue("", 1 == c.getQuantity());
      c.setQuantity(12);
      Assert.assertTrue("", 12 == c.getQuantity());
   }
   /**
    *
    */
   @Test public void setIngredientsTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour");
      String[] ingredientsIn = {"flour", "sugar", "dark chocolate chips",
         "butter", "baking soda", "salt"};
      c.setIngredients(ingredientsIn);
      Assert.assertEquals("", "butter", c.getIngredients()[3]);
   }
   /**
    *
    */
   @Test public void resetCountTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      BakedItem.resetCount();
      Assert.assertEquals("", 0, c.getCount());
   }
   /**
    *
    */
   @Test public void toStringTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12,
            "flour", "sugar", "dark chocolate chips",
            "butter", "baking soda", "salt");
      boolean result1 = c.toString().contains("baking soda,");
      boolean result2 = c.toString().contains("salt)");
      Assert.assertTrue("", result1 && result2);
   }
   /**
    *
    */
   @After public void after() {
      BakedItem.resetCount();
   }
}