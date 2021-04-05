package Cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.ArrayList;

public class OrderingCoffeeController {

   protected Order currentCoffees = new Order();

   @FXML
   protected CheckBox caramelCheckbox, syrupCheckbox, milkCheckbox, creamCheckbox, whippedCheckbox;

   @FXML
   protected TextField priceTextfield;

   @FXML
   protected ComboBox sizeCombobox, numCoffeeComboBox;
   protected ArrayList<String> adds = new ArrayList<>();
   protected Coffee currentCoffee = new Coffee(0.0, null, adds);

   @FXML
   protected TextArea displayingTextArea;

   //MainMenuController.order.add

   /**
    * DOES NOT WORK : )
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
         //Send an alert to select size first
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
         priceTextfield.setText("" + currentCoffee.price);
         displayingTextArea.appendText( "\n" + currentCoffee.getPrice());
         for (String addIn: adds) {
            displayingTextArea.appendText(addIn+"\n");
         }
      }


   }

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
      priceTextfield.setText("" + currentCoffee.price);
      displayingTextArea.appendText( "\n" + currentCoffee.getPrice());
   }


}
