import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.*;

public class CustomerTest {
   @Before
   public void setUp() throws Exception {

   }

   @Test
   public void setLocationTest2() throws Exception {
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.setLocation("Atlanta", "GA");
      Assert.assertEquals("Atlanta, GA", cstmr.getLocation());
   }
    
   @Test
   public void setLocationTest() throws Exception {
      Customer cstmr = new Customer("Lane, Jane");
      cstmr.setLocation("Boston, MA");
      Assert.assertEquals("Boston, MA", cstmr.getLocation());
   }
   
   @Test
   public void changeBalanceTest() {
    Customer cstmr = new Customer("Lane, Jane");
    cstmr.changeBalance(100);
    Assert.assertEquals(100, cstmr.getBalance(), 0.000001);
   }
   
   @Test
   public void toStringTest() {
      
   }
}