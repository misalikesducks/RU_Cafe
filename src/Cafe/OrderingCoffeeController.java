package Cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.ArrayList;

public class OrderingCoffeeController {

   @FXML
   CheckBox caramelCheckbox, syrupCheckbox, milkCheckbox, creamCheckbox, whippedCheckbox;

   @FXML
   TextField priceTextfield;

   @FXML
   ComboBox sizeCombobox;
   ArrayList<String> adds = new ArrayList<>();
   Coffee currentCoffee = new Coffee("Coffee", 0.0, null, adds);

   @FXML
   TextArea displayingTextArea;

   /**
    * DOES NOT WORK : )
    * @param event
    */
   @FXML
   void getAddins(ActionEvent event){
      if(caramelCheckbox.isSelected())
         currentCoffee.add(caramelCheckbox.getText());
      else
         currentCoffee.remove(caramelCheckbox.getText());
      if(syrupCheckbox.isSelected())
         currentCoffee.add(syrupCheckbox.getText());
      else
         currentCoffee.remove(syrupCheckbox.getText());
      if(milkCheckbox.isSelected())
         currentCoffee.add(milkCheckbox.getText());
      else
         currentCoffee.remove(milkCheckbox.getText());
      if(creamCheckbox.isSelected())
         currentCoffee.add(syrupCheckbox.getText());
      else
         currentCoffee.remove(syrupCheckbox);
      if(whippedCheckbox.isSelected())
         currentCoffee.add(whippedCheckbox.getText());
      else
         currentCoffee.remove(whippedCheckbox.getText());

      priceTextfield.setText("" + currentCoffee.price);
      displayingTextArea.appendText(currentCoffee.getItem() + "\n" + currentCoffee.getPrice());
      for (String addIn: adds) {
         displayingTextArea.appendText(addIn+"\n");
      }
   }


}
