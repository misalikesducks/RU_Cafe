package sample;

import java.util.ArrayList;

public class Order implements Customizable{
   //keeps the list of menuItems
   protected int orderID;
   protected ArrayList<MenuItem> items;
   public static int ID_NUMBER = 100001;

   public Order(ArrayList<MenuItem> items){
      this.items = items;
      this.orderID = ID_NUMBER;
      ID_NUMBER++;
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
         return this.items.remove((MenuItem) obj);
      }
      return false;
   }
}
