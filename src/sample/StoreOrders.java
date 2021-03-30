package sample;

import java.util.ArrayList;

public class StoreOrders implements Customizable{
   // keeps the list of orders
   protected ArrayList<Order> orders;

   public boolean add(Object obj){
      return false;
   }
   public boolean remove(Object obj){
      return false;
   }
}
