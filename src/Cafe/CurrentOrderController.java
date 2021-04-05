package Cafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;


/**
 * CurrentOrderController is the operational class for the JavaFX CurrentOrder GUI
 * @author Connie Chen, Tiffany Lee
 */
public class CurrentOrderController {

   @FXML
   protected ListView ordersListView;

   @FXML
   protected ObservableList<String> observableList = FXCollections.observableArrayList();

   @FXML
   void initialize(){
      for(int i = 0; i < MainMenuController.currOrder.items.size(); i++){
         observableList.add(MainMenuController.currOrder.items.get(i).toString());
      }
      ordersListView.setItems(observableList);
   }

   @FXML
   void removeSelected(ActionEvent event){
      // update subtotal
      // update sales tax
      // update total

      // error check if currOrder is empty or if they didn't select anything

      // remove item from order

      if(MainMenuController.currOrder.getItems().size() == 0){
         Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
         orderIsEmptyAlert.setContentText("Current order is empty.");
         orderIsEmptyAlert.show();
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

         MainMenuController.currOrder = new Order(); // makes a new Order (updates orderID)

      }
   }
}
