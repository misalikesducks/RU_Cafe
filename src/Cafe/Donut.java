package Cafe;

/**
 * Donut Class represents instances of menuItem that are specific to donuts
 * Each donut has a type, price, flavour, and quantity
 */
public class Donut extends MenuItem{
   protected String type;
   protected int quantity;
   public static final double YEAST_PRICE = 1.39;
   public static final double CAKE_PRICE = 1.59;
   public static final double DONUT_HOLE_PRICE = 0.33;

   // find a way to store the flavour of the donuts they add

   public Donut(String item, double price, String type) {
      super(item, price);
      this.type = type;
   }

   @Override
   public double itemPrice(){
      if(type.equals("yeast"))
         return this.quantity * YEAST_PRICE;
      else if (type.equals("cake"))
         return this.quantity * CAKE_PRICE;
      else
         return this.quantity * DONUT_HOLE_PRICE;
   }
}
