package sample;

import java.util.ArrayList;

public class MenuItem implements Customizable{
   protected String item;
   protected double price;


   public MenuItem(String item, double price){
      this.item = item;
      this.price = price;
   }

   public boolean add(Object obj){
      return false;
   }
   public boolean remove(Object obj){
      return false;
   }
}
