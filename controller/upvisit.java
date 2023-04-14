package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class upvisit {
    @FXML
    private Button closeButton;
    private String id;
    @FXML
    private Button save;

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

    public void setID(String id){
        this.id = id;
    }
    @FXML
    void closeButtonAction(){

        Stage stage = (Stage) closeButton.getScene().getWindow();

        stage.close();
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
        String s = "Update visit set VisiterNum='" + s5.getText()  +  "',SSN='" +s7.getText()+ "'";

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
            String sql = "select * From visit where visitID ='" + id + "'";
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
