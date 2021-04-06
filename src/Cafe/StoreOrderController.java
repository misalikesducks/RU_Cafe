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
        int numOrders = MainMenuController.currStoreOrder.getOrders().size();
        for(int i = 1; i <= numOrders; i++){
            orderNumComboBox.getItems().add(i);
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
        int orderToDisplay = Integer.parseInt(orderNumComboBox.getValue().toString());
        for(int i = 0; i < MainMenuController.currStoreOrder.getOrders().get(orderToDisplay - 1).getItems().size(); i++){
            observableList.add(MainMenuController.currStoreOrder.getOrders().get(orderToDisplay - 1).getItems().get(i));
        }
        displayOrdersListView.setItems(observableList);
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
