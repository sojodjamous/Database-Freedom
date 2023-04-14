package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class laws {

    @FXML
    private Button back;

    @FXML
    void back1(ActionEvent event)throws IOException {
        if(back==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visiter.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }

}
