package Cafe;

import java.util.ArrayList;

public class Order implements Customizable{
   //keeps the list of menuItems
   protected int orderID;
   protected double subTotal;
   protected ArrayList<MenuItem> items;
   public static int ID_NUMBER = 100001;

   public Order(){
      //this.items = items; -> should be an empty arrayList at first
      this.orderID = ID_NUMBER;
      this.subTotal = 0.00;
      items = new ArrayList<MenuItem>();
      //ID_NUMBER++;
   }

   public double getSubTotal(){
      return subTotal;
   }

   public boolean add(Object obj){
      if(obj instanceof MenuItem){
         if(this.items.add((MenuItem) obj)){
            ID_NUMBER++;
            subTotal += ((MenuItem) obj).getPrice();
            return true;
         }
      }
      return false;
   }

   public boolean remove(Object obj){
      if(obj instanceof MenuItem){
         subTotal -= ((MenuItem) obj).getPrice();
         return this.items.remove((MenuItem) obj);
      }
      return false;
   }
}
