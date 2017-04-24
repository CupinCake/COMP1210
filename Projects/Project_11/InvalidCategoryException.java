/**
 * @author Perry Bunn
 * @version 4/24/17
 */
public class InvalidCategoryException extends Exception {
   /**
    *
    * @param catagory takes in the invalid category
    */
   public InvalidCategoryException(String catagory) {
      super("For category: " + "\"" + category + "\"")
   }
}