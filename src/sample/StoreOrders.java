package sample;

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
         return this.orders.remove((Order) obj);
      }
      return false;
   }
}
