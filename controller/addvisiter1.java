package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addvisiter1 {
    @FXML
    private TextField s1;

    @FXML
    private TextField s2;

    @FXML
    private TextField s4;

    @FXML
    private TextField s6;

    @FXML
    private TextField s5;

    @FXML
    private TextField s7;

    @FXML
    private TextField s8;

    @FXML
    private TextField s3;

    @FXML
    private Button save;
    @FXML
    private Button closeButton;
    @FXML
    private void closeButtonAction(){

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();
    }



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
        String s="insert into visitor values('"+s1.getText()+"','"+s2.getText()+"','"+s3.getText()+"','"+s4.getText()+"','"+s5.getText()+"','"+s6.getText()+"')";
        String s11="insert into prisonerVisiter values('"+s7.getText()+"','"+s1.getText()+"','"+s8.getText()+"')";
        st.executeUpdate(s);
        st.executeUpdate(s11);
        conn.commit();
        conn.close();
        JOptionPane.showMessageDialog(null, "   visitor Add  ");
        s1.setText(" ");s2.setText(" ");s3.setText("  ");s4.setText(" ");s5.setText(" ");s6.setText(" ");
        s7.setText(" ");   s8.setText(" ");


    }

    }
