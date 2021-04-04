package Cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.text.DecimalFormat;

public class OrderingDonutController {

    private Order currOrder = new Order();

    // note sure if the indexes of comboboxes start from 0 or 1
    public static final int YEAST = 0;
    public static final double CAKE = 1;
    public static final double DONUT_HOLE = 2;

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
        if(donutTypeComboBox.getSelectionModel().getSelectedIndex() == YEAST){
            flavorsListView.getItems().add("Strawberry");
            flavorsListView.getItems().add("Matcha");
            flavorsListView.getItems().add("Glazed");
        } else if(donutTypeComboBox.getSelectionModel().getSelectedIndex() == CAKE){
            flavorsListView.getItems().add("Chocolate");
            flavorsListView.getItems().add("Strawberry frosted");
            flavorsListView.getItems().add("Jelly");
        } else{
            flavorsListView.getItems().add("Jelly");
            flavorsListView.getItems().add("Cinnamon");
            flavorsListView.getItems().add("Lemonade");
        }
    }

    @FXML
    void displaySubtotal(ActionEvent event){
        subTotalTextField.appendText(convertToMoney(currOrder.getSubTotal()));
    }

    @FXML
    void addDonut(ActionEvent event){
        // handle the errors - checking if everything is correctly selected
        // add the donut by creating a new donut object
    }

    @FXML
    void removeDonut(ActionEvent event){
        // make sure i have something selected that i'm removing
        // remove the donut
    }

    @FXML
    void addToOrder(ActionEvent event){

    }

    // find a better spot to put this
    public String convertToMoney(double number){
        String pattern = "$#,##0.00";
        DecimalFormat formatMoney = new DecimalFormat(pattern);
        return formatMoney.format(number);
    }
}
