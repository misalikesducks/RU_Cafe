package sample;

/**
 * Donut Class repretents instances of menuItem that are specific to donuts
 * Each donut has a type and price
 */
public class Donut extends MenuItem {
   protected String type;


   public Donut(String item, double price, String type) {
      super(item, price);
      this.type = type;
   }

   @Override
   public double calculatePrice(){
      if(type.equals("yeast"))
         return 1.39;
      else if (type.equals("cake"))
         return 1.59;
      else
         return 0.33;
   }
}
