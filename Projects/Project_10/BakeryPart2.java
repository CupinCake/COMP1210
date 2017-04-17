import java.io.IOException;

/**
 * @author Perry Bunn
 * @version 4/12/2017
 */

public class BakeryPart2 {
   public static void main(String[] args) throws IOException {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      } else {
         String fileName = args[0];
         BakedItemList a = new BakedItemList();
         try {
            a.readItemFile(fileName);
            a.generateReport();
            a.generateReportByClass();
            a.generateReportByPrice();
            a.generateReportByFlavor();
            a.generateExcludedRecordsReport();
         } catch (IOException e) {
//            e.printStackTrace();
         }
      }
   }
}
