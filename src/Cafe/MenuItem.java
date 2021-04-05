package Cafe;

public class MenuItem{
   //protected String item;
   protected double price;
   protected int quantity;

   public MenuItem(double price){
      //this.item = item;
      this.price = price;
      this.quantity = quantity;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public void setQuantity(int quantity){this.quantity = quantity;}

   public double getPrice(){
      return this.price;
   }

   //public String getItem(){
   //   return this.item;
   //}

   public double itemPrice(){
      return 0.0;
   }
}
