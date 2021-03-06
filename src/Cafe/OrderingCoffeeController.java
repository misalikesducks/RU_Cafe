package Cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 * OrderingCoffeeController is the operational class for the JavaFX OrderingCoffee GUI
 * @author Connie Chen, Tiffany Lee
 */
public class OrderingCoffeeController {
   protected Order currentCoffeeOrder = MainMenuController.currOrder;
   protected ArrayList<String> adds = new ArrayList<>();
   protected Coffee currentCoffee = new Coffee(0.0, null, 1, adds);

   @FXML
   protected CheckBox caramelCheckbox, syrupCheckbox, milkCheckbox, creamCheckbox, whippedCheckbox;

   @FXML
   protected TextField priceTextfield;

   @FXML
   protected ComboBox sizeCombobox, numCoffeeComboBox;

   @FXML
   protected TextArea displayingTextArea;

   /**
    * Adds the user-selected coffee add-in options to the arrayList
    * @param event
    */
   @FXML
   void getAddins(ActionEvent event){
      if(sizeCombobox.getValue() == null){
         Alert noSizeAlert = new Alert(Alert.AlertType.ERROR);
         noSizeAlert.setContentText("Select the size");
         noSizeAlert.show();
      }else if(numCoffeeComboBox.getValue() == null){
         Alert noNumAlert = new Alert(Alert.AlertType.ERROR);
         noNumAlert.setContentText("Select Quantity");
         noNumAlert.show();
      }else{
         adds = currentCoffee.addIns;
         if(caramelCheckbox.isSelected() && !adds.contains(caramelCheckbox.getText()))
            currentCoffee.add(caramelCheckbox.getText());
         else if(!caramelCheckbox.isSelected())
            currentCoffee.remove(caramelCheckbox.getText());
         if(syrupCheckbox.isSelected() && !adds.contains(syrupCheckbox.getText()))
            currentCoffee.add(syrupCheckbox.getText());
         else if(!syrupCheckbox.isSelected())
            currentCoffee.remove(syrupCheckbox.getText());
         if(milkCheckbox.isSelected() && !adds.contains(milkCheckbox.getText()))
            currentCoffee.add(milkCheckbox.getText());
         else if(!milkCheckbox.isSelected())
            currentCoffee.remove(milkCheckbox.getText());
         if(creamCheckbox.isSelected() && !adds.contains(creamCheckbox.getText()))
            currentCoffee.add(creamCheckbox.getText());
         else if(!creamCheckbox.isSelected())
            currentCoffee.remove(creamCheckbox.getText());
         if(whippedCheckbox.isSelected() && !adds.contains(whippedCheckbox.getText()))
            currentCoffee.add(whippedCheckbox.getText());
         else if(!whippedCheckbox.isSelected())
            currentCoffee.remove(whippedCheckbox.getText());
         currentCoffee.setPrice(currentCoffee.itemPrice());
         priceTextfield.setText("" + StoreOrders.convertToMoney(currentCoffee.getPrice()));
         displayingTextArea.appendText( currentCoffee.toString() + "\n");
      }
   }

   /**
    * Assigns the current coffee size to the one the user selected
    * @param event
    */
   @FXML
   void selectSize(ActionEvent event){
      if(sizeCombobox.getValue().equals("Venti")){
         currentCoffee.setSize("Venti");
      }else if(sizeCombobox.getValue().equals("Grande")){
         currentCoffee.setSize("Grande");
      }else if(sizeCombobox.getValue().equals("Tall")){
         currentCoffee.setSize("Tall");
      }else{
         currentCoffee.setSize("Short");
      }
      currentCoffee.setPrice(currentCoffee.itemPrice());
      priceTextfield.setText("" + StoreOrders.convertToMoney(currentCoffee.getPrice()));
      displayingTextArea.appendText( currentCoffee.toString() + "\n");
   }

   /**
    * Assigns the quantity of coffee to user selection
    * @param event
    */
   @FXML
   void selectQuantity(ActionEvent event){
      if(sizeCombobox.getValue() == null){
         Alert noSizeAlert = new Alert(Alert.AlertType.ERROR);
         noSizeAlert.setContentText("Select the size");
         noSizeAlert.show();
      }else{
         currentCoffee.setQuantity(Integer.parseInt(numCoffeeComboBox.getValue().toString()));
         currentCoffee.setPrice(currentCoffee.itemPrice());
         priceTextfield.setText("" + StoreOrders.convertToMoney(currentCoffee.getPrice()));
         displayingTextArea.appendText( currentCoffee.toString() + "\n");
      }
   }

   /**
    * Adds coffee item to the order list
    * @param event
    */
   @FXML
   void addCoffeeToOrder(ActionEvent event){
      try{
         if(sizeCombobox.getValue() == null){
            Alert noSizeAlert = new Alert(Alert.AlertType.ERROR);
            noSizeAlert.setContentText("Select the size");
            noSizeAlert.show();
         }else if(numCoffeeComboBox.getValue() == null){
            Alert noNumAlert = new Alert(Alert.AlertType.ERROR);
            noNumAlert.setContentText("Select Quantity");
            noNumAlert.show();
         }else if(currentCoffeeOrder.getItems().add(currentCoffee)){
            currentCoffeeOrder.setSubTotal();
            Alert orderConfirm = new Alert(Alert.AlertType.CONFIRMATION);
            orderConfirm.setContentText("Added to Order");
            orderConfirm.show();

            Stage stage = (Stage) sizeCombobox.getScene().getWindow();
            stage.close();
         }else{
            throw new Exception("Could not add");
         }
      }catch (Exception e) {
         Alert couldNotAddAlert = new Alert(Alert.AlertType.ERROR);
         couldNotAddAlert.setContentText("Something went wrong here");
         couldNotAddAlert.show();
      }
   }
}
