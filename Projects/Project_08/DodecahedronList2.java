import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
/**
@author perry bunn
@version 2/27/17
*/
public class DodecahedronList2 {
   private String listName;
   private Dodecahedron[] dodObjList;
   private int arrSize =  dodObjList.length;
   /**
   @param listNameIn input for the listName
   @param dodObjListIn input for the dodObjList
   */
   public DodecahedronList2(String listNameIn, Dodecahedron[] dodObjListIn) {
      listName = listNameIn;
      dodObjList = dodObjListIn;
   }
   /**
   @return returns the name of the list
   */
   public String getName() {
      return listName;
   }
   /**
   @return retuns the total number of objs in the array
   */
   public int numberOfDodecahedrons() {
      return dodObjList.length;
   }
   /**
   @return returns the total surface area
   */
   public double totalSurfaceArea() {
      double total = 0;
      for (int i = 0; i < dodObjList.length; i++) {
         total += dodObjList[i].surfaceArea();
      }
      /*
      int index = 0;
      while (index < dodObjList.length) {
         total += dodObjList.get(index).surfaceArea();
         index++;
      }
      */
      return total;
   }
   /**
   @return returns the total volume
   */
   public double totalVolume() {
      double total = 0;
      for (int i = 0; i < dodObjList.length; i++) {
         total += dodObjList[i].volume();
      }
      return total;
   }
   /**
   @return returns the average surface area
   */
   public double averageSurfaceArea() {
      double total = 0;
      for (int i = 0; i < dodObjList.length; i++) {
         total += (dodObjList[i].surfaceArea()) / dodObjList.length;
      }
      return total;
   }
   /**
   @return returns the average volume
   */
   public double averageVolume() {
      double total = 0;
      for (int i = 0; i < dodObjList.length; i++) {
         total += (dodObjList[i].volume()) / dodObjList.length;
      }
      return total;
   }
   /**
   @return return the average surfaec to volume ratio
   */
   public double averageSurfaceToVolumeRatio() {
      double total = 0;
      for (int i = 0; i < dodObjList.length; i++) {
         total += dodObjList[i].surfaceToVolumeRatio() 
                                          / dodObjList.length;
      }
      return total;
   }
   /**
   @return returns the obj atributes
   */
   public String toString() {
      String result = listName + "\n";
      for (int i = 0; i < dodObjList.length; i++) {
         result += "\n" + dodObjList[i].toString() + "\n";
      }
      return result;
   }
   /**
   @return returns the summary of the array
   */
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "----- Summary for " + listName + " -----\n"
            + "Number of Dodecahedrons: " + dodObjList.length + "\n"
            + "Total Surface Area: " + fmt.format(totalSurfaceArea()) + "\n"
            + "Total Volume: " + fmt.format(totalVolume()) + "\n"
            + "Average Surface Area: " + fmt.format(averageSurfaceArea()) + "\n"
            + "Average Volume: " + fmt.format(averageVolume()) + "\n" 
            + "Average Surface/Volume Ratio: "
            + fmt.format(averageSurfaceToVolumeRatio());
   }

   //-------------------------------------------------------------------------//
   // Project 6 below
   //-------------------------------------------------------------------------//

   /**
    *
    * @return returns the Dodecahedron list
    */
   public Dodecahedron[] getList() {
      return dodObjList;
   }

   /**
    *
    * @param fileNameIn takes a file name in to look for
    * @return returns the list generated from the file
    * @throws IOException incase the file is not found
    */
   public DodecahedronList2 readFile(String fileNameIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Dodecahedron[] dodObjList2;
      String dodObjListName = "";
      String label = "";
      String color = "";
      double edge = 0;
      
      dodObjListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Dodecahedron dodObj = new Dodecahedron(label, color, edge);
         for (int i = 0; i < dodObjList2.length; i++) {
            if (dodObjList2[i] == null) {
               dodObjList2[i] = dodObj;
            }
         }
      }
      
      DodecahedronList2 dodList = new DodecahedronList2(dodObjListName,
                                                          dodObjList);
      return dodList;
   }

   /**
    *
    * @param labelIn takes input for label in the constructor.
    * @param colorIn takes input for color in the constructor.
    * @param edgeIn takes input for the edge in the constructor.
    */
   public void addDodecahedron(String labelIn, String colorIn, double edgeIn) {
      Dodecahedron dodObj = new Dodecahedron(labelIn, colorIn, edgeIn);
      for (int i = 0; i < dodObjList.length; i++) {
            if (dodObjList[i] == null) {
               dodObjList[i] = dodObj;
            }
         }
   }

   /**
    *
    * @param labelIn takes the label to find in the arraylist
    * @return returns the object found in the arraylist
    */
   public Dodecahedron findDodecahedron(String labelIn) {
      for (Dodecahedron dodObj : dodObjList) {
         if (dodObj.getLabel().equalsIgnoreCase(labelIn)) {
            return dodObj;
         }
      }
      return null;
   }

   /**
    *
    * @param labelIn takes the label to delete from the arraylist
    * @return returns the object deleted
    */
   public Dodecahedron deleteDodecahedron(String labelIn) {
      int index = dodObjList.asList.indexOf(findDodecahedron(labelIn));
      
      if (index >= 0) {
         return dodObjList.remove(index);
      } else {
         return null;
      }
   }

   /**
    *
    *
    * @param labelIn takes input for label to find in the arraylist.
    * @param colorIn takes input for color in the constructor.
    * @param edgeIn takes input for the edge in the constructor.
    * @return returns if the edit was successful
    */
   public boolean editDodecahedron(String labelIn, String colorIn, 
                                                   double edgeIn) {
      boolean result = false;
      for (Dodecahedron dodObj : dodObjList) {
         if (dodObj.getLabel().equals(labelIn)) {
            dodObj.setColor(colorIn);
            dodObj.setEdge(edgeIn);
            result = true;
            break;
         }
      }
      return result;
   }
}