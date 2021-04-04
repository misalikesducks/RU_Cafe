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

   public Coffee(ArrayList<String> addIns){
      super(0.0);
      this.size = null;
      this.addIns = addIns;
   }
   public Coffee(double price, String size, ArrayList<String> addIns) {
      super(price);
      this.size = size;
      this.addIns = addIns;
   }

   public void setSize(String size) {
      this.size = size;
   }

   @Override
   public double itemPrice(){
      double itemPrice = EMPTY;
      switch(this.size){
         case "Short":
            itemPrice += SHORT;
            break;
         case "Tall":
            itemPrice += TALL;
            break;
         case "Grande":
            itemPrice += GRANDE;
            break;
         case "Venti":
            itemPrice += VENTI;
      }
      itemPrice += addIns.size() * ADD_IN;
      return itemPrice;
   }

   @Override
   public boolean add(Object obj){
      if(obj instanceof String){
         String adding = (String) obj;
         this.addIns.add(adding);
         return true;
      }
      return false;
   }

   @Override
   public boolean remove(Object obj){
      if(obj instanceof String){
         String removes = (String) obj;
         this.addIns.remove(removes);
         return true;
      }
      return false;
   }
}
