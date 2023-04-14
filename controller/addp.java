package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addp {
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

    @FXML
    private Button closeButton;

    @FXML
    private Button sava;



    @FXML
    void sav(ActionEvent event) throws SQLException {
        String url,user,password;
        url="jdbc:oracle:thin:@localhost:1521:xe";
        user="c##sojodmasa";
        password="123456";

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn=DriverManager.getConnection(url,user,password);
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
        String s="insert into prisoner values('"+s1.getText()+"','"+s2.getText()+"','"+s3.getText()+"','"+s4.getText()+"','"+s6.getText()+"','"+s5.getText()+"','"+s7.getText()+"')";
     //   String s = "select * From prisoner";
        st.executeUpdate(s);
        conn.commit();
        conn.close();
        JOptionPane.showMessageDialog(null, "   prisoner Add  ");
        s1.setText(" ");s2.setText(" ");s3.setText("  ");s4.setText(" ");s5.setText(" ");s6.setText(" ");
        s7.setText(" ");
    }


    @FXML
    private void closeButtonAction(){

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();
    }

}
