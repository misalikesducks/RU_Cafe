package Cafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * CurrentOrderController is the operational class for the JavaFX CurrentOrder GUI
 * @author Connie Chen, Tiffany Lee
 */
public class CurrentOrderController {

   @FXML
   protected ListView ordersListView;

   @FXML
   protected TextField subtotalTextField, salesTaxTextField, totalTextField;

   @FXML
   protected ObservableList<String> observableList = FXCollections.observableArrayList();

   @FXML
   void initialize(){
      for(int i = 0; i < MainMenuController.currOrder.items.size(); i++){
         observableList.add(MainMenuController.currOrder.items.get(i).toString());
      }
      ordersListView.setItems(observableList);
      System.out.println(MainMenuController.currOrder.getSubTotal());
      subtotalTextField.setText(StoreOrders.convertToMoney(MainMenuController.currOrder.getSubTotal()));
      MainMenuController.currOrder.setSalesTax();
      salesTaxTextField.setText(StoreOrders.convertToMoney(MainMenuController.currOrder.getSalesTax()));
      MainMenuController.currOrder.setTotal();
      totalTextField.setText(StoreOrders.convertToMoney(MainMenuController.currOrder.getTotal()));
   }

   @FXML
   void removeSelected(ActionEvent event){
      // update sales tax
      // update total

      // error check if currOrder is empty or if they didn't select anything

      // remove item from order

      if(MainMenuController.currOrder.getItems().size() == 0){
         Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
         orderIsEmptyAlert.setContentText("Current order is empty.");
         orderIsEmptyAlert.show();
      }else if(ordersListView.getSelectionModel().getSelectedItems() == null){
         Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
         orderIsEmptyAlert.setContentText("No item selected to remove.");
         orderIsEmptyAlert.show();
      }else{
         MainMenuController.currOrder.getItems().remove( ordersListView.getSelectionModel().getSelectedItems());
         observableList.remove(ordersListView.getSelectionModel().getSelectedItems());
         ordersListView.setItems(observableList);

         subtotalTextField.setText(StoreOrders.convertToMoney(MainMenuController.currOrder.getSubTotal()));
         MainMenuController.currOrder.setSalesTax();
         salesTaxTextField.setText(StoreOrders.convertToMoney(MainMenuController.currOrder.getSalesTax()));
         MainMenuController.currOrder.setTotal();
         totalTextField.setText(StoreOrders.convertToMoney(MainMenuController.currOrder.getTotal()));
      }
   }

   @FXML
   void placeOrder(ActionEvent event){
      // error check if currOrder is empty
      // add order to StoreOrder arraylist
      // clear order? and close the window?

      if(MainMenuController.currOrder.getItems().size() == 0){
         Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
         orderIsEmptyAlert.setContentText("Current order is empty.");
         orderIsEmptyAlert.show();
      }else {
         MainMenuController.currStoreOrder.getOrders().add(MainMenuController.currOrder);
         ordersListView.getItems().clear();
         MainMenuController.currOrder = new Order(); // makes a new Order (updates orderID)
      }
   }
}
