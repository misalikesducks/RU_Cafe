package Cafe;

import java.util.ArrayList;

public class Order implements Customizable{
   //keeps the list of menuItems
   protected int orderID;
   protected double subTotal;
   protected double salesTax;
   protected double total;
   protected ArrayList<MenuItem> items;
   public static int ID_NUMBER = 100001;
   public static final double taxRate = 0.06625;

   /**
    * Default Order constructor to create an empty Order ArrayList
    */
   public Order(){
      this.orderID = ID_NUMBER;
      this.subTotal = 0.00;
      this.salesTax = 0;
      this.total = 0.00;
      items = new ArrayList<>();
      ID_NUMBER++;
   }

   public void setSubTotal(){
      for(MenuItem currentItem: items){
         this.subTotal += currentItem.getPrice();
      }
   }

   public double getSubTotal(){
      return subTotal;
   }

   public double getSalesTax(){
      return salesTax;
   }

   public double getTotal(){
      return total;
   }

   public void setSalesTax(){
      this.salesTax = subTotal * taxRate;
   }

   public void setTotal(){
      this.total = subTotal + salesTax;
   }

   public ArrayList<MenuItem> getItems(){
      return items;
   }

   public boolean add(Object obj){
      if(obj instanceof MenuItem){
         if(this.items.add((MenuItem) obj)){
            return true;
         }
      }
      return false;
   }

   public boolean remove(Object obj){
      if(obj instanceof MenuItem){
         return this.items.remove(obj);
      }
      return false;
   }

   /**
    * Returns a String of all MenuItem Objects in the items ArrayList
    * @return String
    */
   public String print(){
      String allOrders = "" + orderID + ": ";

      for(int i = 0; i < items.size(); i++){
         allOrders += items.get(i).toString();
         if(i != items.size()-1)
            allOrders += ", ";
      }

      return allOrders;
   }
}
