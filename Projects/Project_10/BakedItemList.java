import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * .
 * @author Perry Bunn
 * @version 4/12/2017
 */
public class BakedItemList {
   private String listName;
   private BakedItem[] itemList = new BakedItem[100];
   private int itemCount;
   private String[] excludedRecords = new String[30];
   private int excludedCount;
   private static int listCount = 0;

   /**
    * .
    */
   public BakedItemList() {
      listName = "";
      itemCount = 0;
      excludedCount = 0;
      BakedItemList.listCount++;
   }

   /**
    *
    * @return returns the name of the list
    */
   public String getListName() {
      return listName;
   }

   /**
    *
    * @param listName sets the name of the list
    */
   public void setListName(String listName) {
      this.listName = listName;
   }

   /**
    *
    * @return gets the items in the list
    */
   public BakedItem[] getItemList() {
      return itemList;
   }

   /**
    *
    * @param itemList sets the items in the list
    */
   public void setItemList(BakedItem[] itemList) {
      this.itemList = itemList;
   }

   /**
    *
    * @return gets the numbers of items in the list
    */
   public int getItemCount() {
      return itemCount;
   }

   /**
    *
    * @param itemCount sets the number of items in the list
    */
   public void setItemCount(int itemCount) {
      this.itemCount = itemCount;
   }

   /**
    *
    * @return retuns the excluded items from the list
    */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }

   /**
    *
    * @param excludedRecords sets the excludued items
    */
   public void setExcludedRecords(String[] excludedRecords) {
      this.excludedRecords = excludedRecords;
   }

   /**
    *
    * @return returns the number of excluded items
    */
   public int getExcludedCount() {
      return excludedCount;
   }

   /**
    *
    * @param excludedCount sets the number of excluded items
    */
   public void setExcludedCount(int excludedCount) {
      this.excludedCount = excludedCount;
   }

   /**
    *
    * @return gets teh number of list
    */
   public static int getListCount() {
      return listCount;
   }

   /**
    *
    * @param listCount resets the number of list
    */
   public static void resetListCount(int listCount) {
      BakedItemList.listCount = 0;
   }

   /**
    *
    * @param fileName input for the file name to parse.
    * @throws IOException throws an exception if the file is not found
    */
   public void readItemFile(String fileName) throws IOException {
      Scanner scan = new Scanner(new File(fileName)).useDelimiter(",");
      listName = scan.nextLine();
      String[] elements;
      char type;
      String typeS;
      while (scan.hasNext()) {
         String input = scan.nextLine();
         elements = input.split(",");
         typeS = elements[0];
         type = typeS.toUpperCase().charAt(0);
         switch (type) {
            case 'C' : {
               String nameIn = elements[1];
               String flavorIn = elements[2];
               int quantityIn = Integer.parseInt(elements[3]);
               String[] ingredients = new String[50];
               int j = 0;
               for (int i = 0; i < elements.length - 4; i++) {
                  ingredients[i] = elements[i + 4];
                  j++;
               }
               String[] ingredientsTrim = Arrays.copyOf(ingredients, j);
               Cookie c = new Cookie(nameIn, flavorIn, quantityIn,
                     ingredientsTrim);
               itemList[itemCount] = c;
               itemCount++;
               break;
            }
            case 'P': {
               String nameIn = elements[1];
               String flavorIn = elements[2];
               int quantityIn = Integer.parseInt(elements[3]);
               double crustCostIn = Double.parseDouble(elements[4]);
               String[] ingredients = new String[50];
               int j = 0;
               for (int i = 0; i < elements.length - 5; i++) {
                  ingredients[i] = elements[i + 5];
                  j++;
               }
               String[] ingredientsTrim = Arrays.copyOf(ingredients, j);
               Pie p = new Pie(nameIn, flavorIn, quantityIn, crustCostIn,
                     ingredientsTrim);
               itemList[itemCount] = p;
               itemCount++;
               break;
            }
            case 'K': {
               String nameIn = elements[1];
               String flavorIn = elements[2];
               int quantityIn = Integer.parseInt(elements[3]);
               int layersIn = Integer.parseInt(elements[4]);
               String[] ingredients = new String[50];
               int j = 0;
               for (int i = 0; i < elements.length - 5; i++) {
                  ingredients[i] = elements[i + 5];
                  j++;
               }
               String[] ingredientsTrim = Arrays.copyOf(ingredients, j);
               Cake k = new Cake(nameIn, flavorIn, quantityIn, layersIn,
                     ingredientsTrim);
               itemList[itemCount] = k;
               itemCount++;
               break;
            }
            case 'W': {
               String nameIn = elements[1];
               String flavorIn = elements[2];
               int quantityIn = Integer.parseInt(elements[3]);
               int layersIn = Integer.parseInt(elements[4]);
               int tiersIn = Integer.parseInt(elements[5]);
               String[] ingredients = new String[50];
               int j = 0;
               for (int i = 0; i < elements.length - 6; i++) {
                  ingredients[i] = elements[i + 6];
                  j++;
               }
               String[] ingredientsTrim = Arrays.copyOf(ingredients, j);
               WeddingCake w = new WeddingCake(nameIn, flavorIn, quantityIn,
                     layersIn, tiersIn, ingredientsTrim);
               itemList[itemCount] = w;
               itemCount++;
               break;
            }
            default: {
               excludedRecords[excludedCount] = input;
               excludedCount++;
               break;
            }
         }
      }
   }

   public void generateReport() {
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemList[i].toString() + "\n\n";
      }
      System.out.println(result);
   }

   public void generateReportByClass() {
      BakedItem[] itemListCopy = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(itemListCopy);
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Class)\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemListCopy[i].toString() + "\n\n";
      }
      System.out.println(result);
   }

   public void generateReportByPrice() {
      BakedItem[] itemListCopy = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(itemListCopy, new PriceComparator());
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Price)\n"
            + "---------------------------------------\n\n";
      for (int i = 0; i < itemCount; i++) {
         result += itemListCopy[i].toString() + "\n\n";
      }
      System.out.println(result);
   }

   public void generateReportByFlavor() {
      BakedItem[] itemListCopy = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(itemListCopy, new FlavorComparator());
      String result = "---------------------------------------\n"
            + "Report for Auburn's Best Bakery (by Flavor)\n"
            + "---------------------------------------";
      for (int i = 0; i < itemCount; i++) {
         result += itemListCopy[i].toString() + "\n\n";
      }
      System.out.println(result);
   }

   public void generateExcludedRecordsReport() {
      System.out.println("---------------------------------------\n"
            + "Excluded Records Report\n"
            + "---------------------------------------");
      for (int i = 0; i < excludedCount; i++) {
         System.out.println("*** invalid category *** for line:\n"
               + excludedRecords[i]);
      }
   }
}
