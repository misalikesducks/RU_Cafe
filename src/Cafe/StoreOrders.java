package Cafe;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoreOrders implements Customizable{
   // keeps the list of orders
   protected ArrayList<Order> orders;

   public StoreOrders(){
      this.orders = new ArrayList<Order>();
   }

   public ArrayList<Order> getOrders(){
      return orders;
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

   /**
    * Returns a String of all the Order objects in orders ArrayList
    * @return String
    */
   public String print(){
      String allOrders = "";

      for(Order order : orders){
         allOrders += order.print() + "\n";
      }

      return allOrders;
   }

   /**
    * Converts a Double object into formatted Object that represents currency
    * @param number to be converted to money
    * @return String representing the amount in currency format
    */
   public static String convertToMoney(double number){
      String pattern = "$#,##0.00";
      DecimalFormat formatMoney = new DecimalFormat(pattern);
      return formatMoney.format(number);
   }
}
