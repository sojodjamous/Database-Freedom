package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import oracle.jdbc.pool.OracleDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class employee {
    @FXML
    private Button aaa;
    @FXML
    private Button a8;
    @FXML
    private Button back;

    @FXML
    private Button a6;

    @FXML
    private Button a5;

    @FXML
    private Button so;

    @FXML
    private Button a2;

    @FXML
    private Button a1;

    @FXML
    private Button a4;

    @FXML
    void a(ActionEvent event) throws IOException {
        if(a1==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/prisoner.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }
    @FXML
    void a88(ActionEvent event) throws IOException {
        if(a8==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/regvisit.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }

    @FXML
    void a22(ActionEvent event)throws IOException {
        if(a2==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/informations.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }

    @FXML
    void a44(ActionEvent event) throws IOException{
        if(a4==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/reguser.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }

    @FXML
    void a55(ActionEvent event) throws IOException{
        if(a5==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visitinformations.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }

    @FXML
    void a66(ActionEvent event) throws IOException {



        OracleDataSource ods;
        try{

            ods=new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##sojodmasa");
            ods.setPassword("123456");
            Connection con=ods.getConnection();
            InputStream input=new FileInputStream(new File("j.jrxml"));
            JasperDesign jd= JRXmlLoader.load(input);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null, con);
            JFrame frame=new JFrame("report");
            frame.getContentPane().add(new JRViewer(jp));
            frame.pack();
            frame.setVisible(true);

            input.close();

            con.close();
        }catch(Exception ex){
            ex.printStackTrace();

        }
    }

    @FXML
    void back1(ActionEvent event) throws IOException{
        if(back==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/logadmin.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }
    @FXML
    void aa(ActionEvent event) throws IOException{
        if(aaa==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visiterinfor.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }

    }


    @FXML
    void s(ActionEvent event) throws IOException{
        if(so==event.getSource()){

            Parent m = FXMLLoader.load(getClass().getResource("/FXML/visit.fxml"));

            Scene ms = new Scene(m);
            Stage m3;
            m3=(Stage)((Node)event.getSource()).getScene().getWindow();
            m3.setScene(ms);
            m3.show();
        }
    }
}
