package Cafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * OrderingDonutController is the operational class for the JavaFX OrderDonuts GUI
 * @author Connie Chen, Tiffany Lee
 */
public class OrderingDonutController {

    protected Order currDonutOrder = new Order();

    @FXML
    private ComboBox donutTypeComboBox, amountComboBox;

    @FXML
    private ListView flavorsListView, addedListView;

    @FXML
    private TextField subTotalTextField;

    /**
     * Displays flavours for each respective donut type
     * @param event
     */
    @FXML
    void showFlavours(ActionEvent event){
        flavorsListView.getItems().clear();
        if(donutTypeComboBox.getValue().equals("Yeast")){
            flavorsListView.getItems().add("Strawberry");
            flavorsListView.getItems().add("Matcha");
            flavorsListView.getItems().add("Glazed");
        } else if(donutTypeComboBox.getValue().equals("Cake")){
            flavorsListView.getItems().add("Chocolate");
            flavorsListView.getItems().add("Strawberry Frosted");
            flavorsListView.getItems().add("Jelly");
        } else if(donutTypeComboBox.getValue().equals("Donut Hole")){
            flavorsListView.getItems().add("Jelly");
            flavorsListView.getItems().add("Cinnamon");
            flavorsListView.getItems().add("Lemonade");
        }
    }

    /**
     * Adds donut(s) to the order, updating the sub-total of the order on the GUI
     * @param event
     */
    @FXML
    void addDonut(ActionEvent event){
        if(donutTypeComboBox.getValue() == null){
            Alert noTypeAlert = new Alert(Alert.AlertType.ERROR);
            noTypeAlert.setContentText("No type selected.");
            noTypeAlert.show();
        }else if(amountComboBox.getValue() == null){
            Alert noAmountAlert = new Alert(Alert.AlertType.ERROR);
            noAmountAlert.setContentText("No amount selected.");
            noAmountAlert.show();
        }else if(flavorsListView.getSelectionModel().getSelectedItem() == null){
            Alert noFlavourAlert = new Alert(Alert.AlertType.ERROR);
            noFlavourAlert.setContentText("No flavour selected.");
            noFlavourAlert.show();
        } else {
            Donut newDonut = new Donut((String) donutTypeComboBox.getValue(),
                    (String) flavorsListView.getSelectionModel().getSelectedItem(),
                    Integer.parseInt((String)amountComboBox.getValue()));
            newDonut.setPrice(newDonut.itemPrice());

            currDonutOrder.add(newDonut);
            currDonutOrder.setSubTotal();
            addedListView.getItems().add(newDonut);
            displaySubtotal();
        }
    }

    /**
     * Removes donut(s) from the order, updating the sub-total of the order on the GUI
     * @param event
     */
    @FXML
    void removeDonut(ActionEvent event){
        if(currDonutOrder.items.isEmpty()) {
            Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
            orderIsEmptyAlert.setContentText("Current order is empty.");
            orderIsEmptyAlert.show();
        }else if(addedListView.getSelectionModel().getSelectedItem() == null){
            Alert noChosenAlert = new Alert(Alert.AlertType.ERROR);
            noChosenAlert.setContentText("No donut selected to remove.");
            noChosenAlert.show();
        }else{
            Donut newDonut = (Donut)addedListView.getSelectionModel().getSelectedItem();
            currDonutOrder.remove(newDonut);
            currDonutOrder.setSubTotal();
            addedListView.getItems().remove(newDonut);
            displaySubtotal();
        }
    }

    /**
     * Adds donuts to the current order
     * @param event
     */
    @FXML
    void addToOrder(ActionEvent event){
        if(currDonutOrder.items.isEmpty()){ // checks if order is empty, returns fal
            Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
            orderIsEmptyAlert.setContentText("Current order is empty.");
            orderIsEmptyAlert.show();
        }else{ // add order to current order
            for(MenuItem item : currDonutOrder.getItems()){
                MainMenuController.currOrder.getItems().add(item);
            }

            //System.out.println(currDonutOrder.print());

            Alert addedAlert = new Alert(Alert.AlertType.CONFIRMATION);
            addedAlert.setContentText("Donut(s) added to order.");
            addedAlert.setHeaderText("Add to order");
            addedAlert.show();
        }
    }

    /**
     * Displays the subtotal of the Donut(s) added to the order on the GUI
     */
    public void displaySubtotal(){
        subTotalTextField.clear();
        subTotalTextField.appendText(StoreOrders.convertToMoney(currDonutOrder.getSubTotal()));
    }
}
