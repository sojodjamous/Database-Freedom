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
import java.io.IOException;
import javax.swing.*;

import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;
import java.sql.*;

public class visit {
    @FXML
    private TextField s4;

    @FXML
    private TextField s6;

    @FXML
    private TextField s2;

    @FXML
    private TextField s7;

    @FXML
    private TextField s5;

    @FXML
    private TextField s3;

    @FXML
    private TextField s1;

    @FXML
    private Button back;

    @FXML
    private Button save;

    @FXML
    void back1(ActionEvent event)throws IOException {
        if(back==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/employee.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }

    @FXML
    void sav(ActionEvent event)  throws SQLException {
        String url,user,password;
        url="jdbc:oracle:thin:@localhost:1521:xe";
        user="c##sojodmasa";
        password="123456";

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn=DriverManager.getConnection(url,user,password);
        conn.setAutoCommit(false);
        Statement st=conn.createStatement();
      //  String s="insert into visit values('"+s4.getText()+"','"+s6.getText()+"','"+s2.getText()+"','"+s7.getText()+"','"+s5.getText()+"','"+s3.getText()+"','"+s1.getText()+"')";
        String s="insert into visit values('"+s1.getText()+"','"+s2.getText()+"','"+s3.getText()+"','"+s4.getText()+"','"+s6.getText()+"','"+s5.getText()+"','"+s7.getText()+"')";

        st.executeUpdate(s);
        conn.commit();
        conn.close();
        JOptionPane.showMessageDialog(null, "   visit Add  ");
        s1.setText(" ");s2.setText(" ");s3.setText("  ");s4.setText(" ");s5.setText(" ");s6.setText(" ");
        s7.setText(" ");


    }

}
