public class Customer implements Comparable<Customer> {
   String name;
   String location;
   double balance;

   public Customer(String nameIn) {
      name = nameIn;
      location ="";
      balance = 0;
   }

   public String getName() {
      return name;
   }

   public void setLocation(String locationIn) {
      location = locationIn;
   }
 
   public void changeBalance(double amount) {
      balance += amount;
   }

   public String getLocation() {
      return location;
   }

   public double getBalance() {
      return balance;
   }

   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }

   public String toString() {
      return getName() + "\n" + getLocation() + "\n" + getBalance();
   }

   public int compareTo(Customer obj) {
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0;
      } else if (this.balance < obj.getBalance()) {
         return -1;
      } else {
         return 1;
      }
  }
}
