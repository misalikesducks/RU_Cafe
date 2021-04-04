package Cafe;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
   // keeps the list of orders
   protected ArrayList<Order> orders;

   public StoreOrders(ArrayList<Order> orders){
      this.orders = orders;
   }

   public boolean add(Object obj){
      if(obj instanceof Order){
         return orders.add((Order) obj);
      }
      return false;
   }

   public boolean remove(Object obj){
      if(obj instanceof Order){
         return orders.remove((Order) obj);
      }
      return false;
   }

   // i don't think we need this, but we should find a place where we initialize the arraylist we're using
   public boolean checkEmpty(){
      return orders.isEmpty();
   }

   public String print(){
      String allOrders = "";



      return allOrders;
   }
}
