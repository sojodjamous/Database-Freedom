package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loguser {



    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;


    @FXML
    private Button goin;


    @FXML
    private Button back;



    @FXML
    void go(ActionEvent event)  throws IOException {


        if(goin==event.getSource()){
            //  System.out.println("m");
            if (this.email.getText().isEmpty() || this.pass.getText().isEmpty() )
            {
                JOptionPane.showMessageDialog(null, "   Please Fill All Fields  ");
                // invalid.setText("Please Fill All Fields");
            }
            else {

                try {
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    String url = "jdbc:oracle:thin:@localhost:1521:xe";
                    Connection con = DriverManager.getConnection(url,"C##sojodmasa","123456");
                    String sql = "Select * from visitor where vID='"+email.getText()+"' and vpassword='"+pass.getText()+"'";
                    PreparedStatement pst = con.prepareStatement(sql);
                    //pst.setString(1, email.getText());
                    // pst.setString(2, pass.getText());
                    ResultSet rs = pst.executeQuery();



                    while(rs.next()){
                        //System.out.println("t");
                    //    System.out.println(rs.getString("vID"));
                        String sf = rs.getString("vID").replaceAll(" ","");
                        if(sf.equals(email.getText())){


                            if(goin==event.getSource()){

                                Parent m = FXMLLoader.load(getClass().getResource("/FXML/visiter.fxml"));

                                Scene ms = new Scene(m);
                                Stage m3;
                                m3=(Stage)((Node)event.getSource()).getScene().getWindow();
                                m3.setScene(ms);
                                m3.show();
                            }


                            return;

                        }

                        else if(!rs.getString("vID").equals(email.getText())) {
                            JOptionPane.showMessageDialog(null, "  ID or password is incorrect  ");
                            //  invalid.setText("Email or password is incorrect");
                            email.setText("");
                            pass.setText("");
                        }}
                } catch (Exception ex) {
                    // goin.go(SController.class.getName()).log(PlatformLogger.Level.SEVERE, null, ex);
                }

            }

        }
    }

    @FXML
    void back1(ActionEvent event) throws IOException {
        if(back==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }
}
