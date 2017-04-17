import java.util.Comparator;

/**
 * @author Perry Bunn
 * @version 4/12/2017
 */

public class FlavorComparator implements Comparator<BakedItem> {
   
   @Override
   public int compare(BakedItem b1, BakedItem b2) {
      return b1.getFlavor().toLowerCase().compareTo(b2.getFlavor()
              .toLowerCase());
   }
}
