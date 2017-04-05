import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class BakeryPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      BakedItem.resetCount();
   }


   /**
    *
    */
   @Test public void mainTest() {
      BakeryPart1.main(null);
      Assert.assertEquals("", 6, BakedItem.getCount());
   }
   /**
    *
    */
   @After public void after() {
      BakedItem.resetCount();
   }
}
