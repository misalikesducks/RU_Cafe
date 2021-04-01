package sample;

/**
 * Donut Class repretents instances of menuItem that are specific to donuts
 * Each donut has a type and price
 */
public class Donut extends MenuItem {
   protected String type;
   protected int quantity;
   public static final double YEAST = 1.39;
   public static final double CAKE = 1.59;
   public static final double DONUT_HOLE = 0.33;

   // find a way to store the flavour of the donuts they add

   public Donut(String item, double price, String type) {
      super(item, price);
      this.type = type;
   }

   @Override
   public double calculatePrice(){
      if(type.equals("yeast"))
         return this.quantity * YEAST;
      else if (type.equals("cake"))
         return this.quantity * CAKE;
      else
         return this.quantity * DONUT_HOLE;
   }
}
