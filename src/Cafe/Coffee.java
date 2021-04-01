package Cafe;

import java.util.ArrayList;

/**
 * Coffee class creates instances of menuItems that are specific to Coffee
 * Coffee is customizable with add-ins and have different sizes/prices
 */
public class Coffee extends MenuItem implements Customizable{
   protected String size;
   protected ArrayList<String> addIns;
   public static final double SHORT = 1.99;
   public static final double TALL = 2.49;
   public static final double GRANDE = 2.99;
   public static final double VENTI = 3.49;
   public static final double ADD_IN = 0.20;
   public static final double EMPTY = 0.0;

   public Coffee(String item, double price, String size, ArrayList<String> addIns) {
      super(item, price);
      this.size = size;
      this.addIns = addIns;
   }

   @Override
   public double itemPrice(){
      double itemPrice = EMPTY;
      switch(this.size){
         case "short":
            itemPrice += SHORT;
            break;
         case "tall":
            itemPrice += TALL;
            break;
         case "grande":
            itemPrice += GRANDE;
            break;
         case "venti":
            itemPrice += VENTI;
      }
      itemPrice += addIns.size() * ADD_IN;
      return itemPrice;
   }

   @Override
   public boolean add(Object obj){
      if(obj instanceof ArrayList){
         ArrayList<String> adding = (ArrayList<String>) obj;
         for (String adds: adding) {
            addIns.add(adds);
         }
         return true;
      }
      return false;
   }
   @Override
   public boolean remove(Object obj){
      if(obj instanceof ArrayList){
         ArrayList<String> removing = (ArrayList<String>) obj;
         for(String removes:removing) {
            addIns.remove(removes);
         }
         return true;
      }
      return false;
   }
}
