package Cafe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;

public class StoreOrderController {
    @FXML
    void exportOrders(ActionEvent event){
        // check if arrayList is empty
        try{
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open Target Directory for the Export");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File exportFile = chooser.showSaveDialog(new Stage());
            if(exportFile != null){
                PrintWriter pw = new PrintWriter(exportFile);
                //pw.print(database.print()); //write to file
                pw.close();
                //show1.appendText("Database export successful.\n");
            }
        }catch(Exception e){
            // error pop-up
            return;
        }
    }
}
