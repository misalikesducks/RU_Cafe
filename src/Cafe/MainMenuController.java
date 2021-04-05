package Cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 * MainMenuController is the operational class for the JavaFX StoreOrder GUI
 * @author Connie Chen, Tiffany Lee
 */
public class MainMenuController {

   protected static Order currOrder = new Order();
   protected static StoreOrders currStoreOrder = new StoreOrders();

   /**
    * Displays the OrderingCoffee GUI
    * @param event
    */
   @FXML
   void loadCoffee(ActionEvent event){
      try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderingCoffee.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.setTitle("Order Coffee");
         stage.show();
      }catch (Exception e){
         e.printStackTrace();
      }
   }

   /**
    * Displays the OrderingDonut GUI
    * @param event
    */
   @FXML
   void loadDonut(ActionEvent event){
      try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderingDonuts.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.setTitle("Order Donuts");
         stage.show();
      }catch (Exception e){
         e.printStackTrace();
      }
   }

   /**
    * Displays the CurrentOrder GUI
    * @param event
    */
   @FXML
   void loadCurrentOrder(ActionEvent event){
      try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrder.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.setTitle("Current Order");
         stage.show();
      }catch (Exception e){
         e.printStackTrace();
      }
   }

   /**
    * Displays the StoreOrder GUI
    * @param event
    */
   @FXML
   void loadStoreOrder(ActionEvent event){
      try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrder.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.setTitle("Store Orders");

         stage.show();
      }catch (Exception e){
         e.printStackTrace();
      }
   }
}
