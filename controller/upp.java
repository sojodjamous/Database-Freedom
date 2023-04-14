package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class upp  {
    @FXML
    private ObservableList guestInfo = FXCollections.observableArrayList();
    @FXML
    private Button closeButton;

    @FXML
    private Button sava;

    @FXML
    private TextField s1;

    @FXML
    private TextField s2;

    @FXML
    private TextField s3;

    @FXML
    private TextField s4;

    @FXML
    private TextField s5;

    @FXML
    private TextField s6;

    @FXML
    private TextField s7;

    private String id;

    @FXML
    void closeButtonAction(){

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();
    }


   public void setID(String id){
        this.id = id;
   }

    @FXML
    void sav(ActionEvent event) throws SQLException {
        String url, user, password;
        url = "jdbc:oracle:thin:@localhost:1521:xe";
        user = "c##sojodmasa";
        password = "123456";

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        String s = "Update prisoner set PrisonName='" + s5.getText() + "',NumOfYearsInPrison='" +s6.getText() + "'";

        st.executeUpdate(s);
        conn.commit();
        conn.close();
    }
    public void fillInfo(){
        try {
            String url, user, password;
            url = "jdbc:oracle:thin:@localhost:1521:xe";
            user = "c##sojodmasa";
            password = "123456";

            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            Statement st = conn.createStatement();
            String sql = "select * From prisoner where PrisonerID ='" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s1.setText(rs.getString(1));
                s2.setText(rs.getString(2));
                s3.setText(rs.getString(3));
                s4.setText(rs.getString(4));
                s6.setText(rs.getString(5));
                s5.setText(rs.getString(6));
                s7.setText(rs.getString(7));
            }


        }catch(Exception e){

        }
    }
}
