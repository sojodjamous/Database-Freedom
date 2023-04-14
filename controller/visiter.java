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

public class visiter {
    @FXML
    private Button a1;

    @FXML
    private Button a2;



    @FXML
    private Button a4;

    @FXML
    private Button a5;

    @FXML
    private Button a6;

    @FXML
    void a11(ActionEvent event) throws IOException {
        if(a1==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/regv.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }

    @FXML
    void a22(ActionEvent event) throws IOException {
        if(a2==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visiti.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }



    @FXML
    void a44(ActionEvent event) throws IOException {
        if(a4==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/laws.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }

    @FXML
    void a55(ActionEvent event) throws IOException {
        if(a5==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visiti.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }

    @FXML
    void a66(ActionEvent event) throws IOException {
        if(a6==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/loguser.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }
}
