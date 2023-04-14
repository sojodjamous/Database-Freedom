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

public class regv {

    @FXML
    private TextField s1;

    @FXML
    private TextField s2;

    @FXML
    private TextField s3;
    @FXML
    private Button back;

    @FXML
    private Button save;

    @FXML
    void back1(ActionEvent event) throws IOException {
        if(back==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visiter.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

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
        String s="insert into visitVisitor values('"+s2.getText()+"','"+s1.getText()+"')";
        String s11="insert into visitPrisoner values('"+s3.getText()+"','"+s1.getText()+"')";

        st.executeUpdate(s);
        st.executeUpdate(s11);
        conn.commit();
        conn.close();
        JOptionPane.showMessageDialog(null, "   The visit has been Recorded  ");
        s1.setText(" ");s2.setText(" ");s3.setText("  ");
    }

    }

