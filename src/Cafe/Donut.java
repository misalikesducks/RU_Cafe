package Cafe;

/**
 * Donut Class represents instances of menuItem that are specific to donuts
 * Each donut has a type, price, flavour, and quantity
 */
public class Donut extends MenuItem{
   protected String type;
   protected String flavour;
   protected int quantity;
   public static final double YEAST_PRICE = 1.39;
   public static final double CAKE_PRICE = 1.59;
   public static final double DONUT_HOLE_PRICE = 0.33;

   // find a way to store the flavour of the donuts they add

   public Donut(String type, String flavour, int quantity) {
      super(0);
      this.type = type;
      this.flavour = flavour;
      this.quantity = quantity;
      this.price = itemPrice();
   }

   @Override
   public double itemPrice(){
      if(type.equals("Yeast"))
         return this.quantity * YEAST_PRICE;
      else if (type.equals("Cake"))
         return this.quantity * CAKE_PRICE;
      else
         return this.quantity * DONUT_HOLE_PRICE;
   }

   public String toString(){
      return flavour + " " + type + " Donut (" + quantity + ")";
   }
}
