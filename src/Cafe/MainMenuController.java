package Cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.sql.SQLTransactionRollbackException;

public class MainMenuController {

   private Order currOrder = new Order();

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
