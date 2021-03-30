package sample;

import java.util.ArrayList;

/**
 * Coffee class creates instances of menuItems that are specific to Coffee
 * Coffee is customizable with add-ins and have different sizes/prices
 */
public class Coffee extends MenuItem implements Customizable{
   protected int size;
   protected ArrayList<String> addIns;

   public Coffee(String item, double price, int size, ArrayList<String> addIns) {
      super(item, price);
      this.size = size;
      this.addIns = addIns;
   }

   @Override
   public double calculatePrice(){
      return 0.0;
   }

   @Override
   public boolean add(Object obj){
      return false;
   }
   @Override
   public boolean remove(Object obj){
      return false;
   }
}
