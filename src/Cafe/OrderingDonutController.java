package Cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.text.DecimalFormat;

public class OrderingDonutController {

    private Order currDonutOrder = new Order();

    @FXML
    private ComboBox donutTypeComboBox, amountComboBox;

    @FXML
    private ListView flavorsListView;

    @FXML
    private TextField subTotalTextField;

    /**
     * Displays flavours for each respective donut type
     * @param event
     */
    @FXML
    void showFlavours(ActionEvent event){
        flavorsListView.getItems().clear();
        // do we want different flavours for each doughnut type?
        if(donutTypeComboBox.getValue().equals("Yeast")){
            flavorsListView.getItems().add("Strawberry");
            flavorsListView.getItems().add("Matcha");
            flavorsListView.getItems().add("Glazed");
        } else if(donutTypeComboBox.getValue().equals("Cake")){
            flavorsListView.getItems().add("Chocolate");
            flavorsListView.getItems().add("Strawberry frosted");
            flavorsListView.getItems().add("Jelly");
        } else if(donutTypeComboBox.getValue().equals("Donut Hole")){
            flavorsListView.getItems().add("Jelly");
            flavorsListView.getItems().add("Cinnamon");
            flavorsListView.getItems().add("Lemonade");
        }
    }

    @FXML
    void addDonut(ActionEvent event){
        // handle the errors - checking if everything is correctly selected
        // add the donut by creating a new donut object

        if(donutTypeComboBox.getValue().equals("Donut Type")){
            Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
            orderIsEmptyAlert.setContentText("what flavour donut u want bro");
            orderIsEmptyAlert.show();
        }else {
            Donut newDonut = new Donut((String) donutTypeComboBox.getValue(),
                    (String) flavorsListView.getSelectionModel().getSelectedItem(), (int) amountComboBox.getValue());

            displaySubtotal();
        }
    }

    @FXML
    void removeDonut(ActionEvent event){
        // make sure i have something selected that i'm removing
        // remove the donut

        displaySubtotal();
    }

    @FXML
    void addToOrder(ActionEvent event){
        if(currDonutOrder.items.isEmpty()){ // checks if order is empty, returns fal
            Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
            orderIsEmptyAlert.setContentText("Yo you no add any donuts wtf?");
            orderIsEmptyAlert.show();
        }else{ // add order to current order

        }
    }

    // find a better spot to put this
    public String convertToMoney(double number){
        String pattern = "$#,##0.00";
        DecimalFormat formatMoney = new DecimalFormat(pattern);
        return formatMoney.format(number);
    }

    public void displaySubtotal(){
        subTotalTextField.clear();
        subTotalTextField.appendText(convertToMoney(currDonutOrder.getSubTotal()));
    }
}
