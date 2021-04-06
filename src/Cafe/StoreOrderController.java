package Cafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.w3c.dom.Text;

import java.io.File;
import java.io.PrintWriter;

/**
 * StoreOrderController is the operational class for the JavaFX StoreOrder GUI
 * @author Connie Chen, Tiffany Lee
 */
public class StoreOrderController {
    public static final int STARTING_ORDER_NUMBER = 1;
    public int numRemoved = 0;

    @FXML
    protected ListView displayOrdersListView;

    @FXML
    protected ComboBox orderNumComboBox;

    @FXML
    protected TextField orderTotalTextField;

    @FXML
    protected ObservableList<MenuItem> observableList = FXCollections.observableArrayList();

    /**
     * Initializes the orderNumComboBox with number of orders currently placed
     */
    @FXML
    void initialize(){
        for(Order order: MainMenuController.currStoreOrder.getOrders()){
            orderNumComboBox.getItems().addAll("" + order.getOrderID());
        }
    }

    /**
     * Event handler for orderNumComboBox
     * Changes displayOrdersListView depending on which order the user has selected
     * @param event
     */
    @FXML
    void getOrder(ActionEvent event){
        displayOrdersListView.getItems().clear();
        observableList.clear();
        int orderIDToDisplay = 0;
        try{
            if(orderNumComboBox.getValue() != null){
                orderIDToDisplay = Integer.parseInt(orderNumComboBox.getValue().toString());
                Order orderToDisplay = MainMenuController.currStoreOrder.findOrder(orderIDToDisplay);

                for(MenuItem item : orderToDisplay.getItems()){
                    observableList.add(item);
                }
                displayOrdersListView.setItems(observableList);
                orderTotalTextField.setText(StoreOrders.convertToMoney(orderToDisplay.getTotal()));
            }else
                throw new Exception("Value does not exist");
        }catch (Exception e){
        }
    }

    /**
     * Event handler for Cancel Order button
     * Cancels a selected order by removing it from the StoreOrder object ArrayList orders
     * @param event
     */
    @FXML
    void cancelOrder(ActionEvent event){
        if(MainMenuController.currStoreOrder.getOrders().size() == 0){
            Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
            orderIsEmptyAlert.setContentText("There are no store orders to remove.");
            orderIsEmptyAlert.show();
        }else if(orderNumComboBox.getValue() == null) {
            Alert orderIsEmptyAlert = new Alert(Alert.AlertType.ERROR);
            orderIsEmptyAlert.setContentText("Order to remove has not be selected.");
            orderIsEmptyAlert.show();
        }else{
            int orderToRemoveID = Integer.parseInt(orderNumComboBox.getValue().toString());
            Order orderToRemove = MainMenuController.currStoreOrder.findOrder(orderToRemoveID);

            MainMenuController.currStoreOrder.getOrders().remove(orderToRemove);

            Alert orderCancelledAlert = new Alert(Alert.AlertType.CONFIRMATION);
            orderCancelledAlert.setContentText("Order has been cancelled.");
            orderCancelledAlert.show();
            orderNumComboBox.getItems().remove("" + orderToRemoveID);
            observableList.clear();
            orderTotalTextField.clear();
            orderNumComboBox.setEditable(true);
            orderNumComboBox.setPromptText("Order");
            orderNumComboBox.setEditable(false);
        }
    }

    /**
     * Event handler for Export Store Orders
     * Exports current Store Orders into a new text file in the user's chosen directory
     * @param event
     */
    @FXML
    void exportOrders(ActionEvent event){
        if(MainMenuController.currStoreOrder.getOrders().size() != 0) {
            try {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Open Target Directory for the Export");
                chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                File exportFile = chooser.showSaveDialog(new Stage());
                if (exportFile != null) {
                    PrintWriter pw = new PrintWriter(exportFile);
                    pw.print(MainMenuController.currStoreOrder.print()); //write to file
                    pw.close();

                    Alert addedAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    addedAlert.setContentText("Order has been exported.");
                    addedAlert.setHeaderText("Successful export");
                    addedAlert.show();
                } else{
                    Alert addedAlert = new Alert(Alert.AlertType.ERROR);
                    addedAlert.setContentText("Order has not been exported.");
                    addedAlert.setHeaderText("Unsuccessful export");
                    addedAlert.show();
                }
            } catch (Exception e) {
                Alert addedAlert = new Alert(Alert.AlertType.ERROR);
                addedAlert.setContentText("Order has not been exported.");
                addedAlert.setHeaderText("Unsuccessful export");
                addedAlert.show();
                return;
            }
        }else{
            Alert addedAlert = new Alert(Alert.AlertType.ERROR);
            addedAlert.setContentText("There are currently no store orders.");
            addedAlert.show();
        }
    }
}
