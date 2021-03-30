package sample;

import java.util.ArrayList;

public class MenuItem implements Customizable{
   protected String item;
   protected double price;


   public MenuItem(String item, double price){
      this.item = item;
      this.price = price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public void setItem(String item){
      this.item = item;
   }

   public double getPrice(){
      return this.price;
   }

   public String getItem(){
      return this.item;
   }

   public double calculatePrice(){
      return price;
   }

   public boolean add(Object obj){
      return false;
   }
   public boolean remove(Object obj){
      return false;
   }
}
