package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class visiti implements Initializable {
    @FXML
    private ObservableList guestInfo = FXCollections.observableArrayList();
    @FXML
    private Button sarch;
    @FXML
    private TableView<?> table;
    @FXML
    private TextField sn;

    @FXML
    private TableColumn<?, ?> Tssn;

    @FXML
    private TableColumn<?, ?> Tfname;

    @FXML
    private TableColumn<?, ?> Tlname;

    @FXML
    private TableColumn<?, ?> Tdonatefor;

    @FXML
    private TableColumn<?, ?> Titem;

    @FXML
    private TableColumn<?, ?> Titem1;

    @FXML
    private TableColumn<?, ?> Titem2;

    @FXML
    private Button back;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            table.getColumns().clear();
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // OracleDataSource ods = new OracleDataSource();
            /// ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##sojodmasa", "123456");
            Statement stm = con.createStatement();

            String insQury = "select * From visit";

            ResultSet rs = stm.executeQuery(insQury);
            guestInfo = FXCollections.observableArrayList();



            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));

                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });


                table.getColumns().addAll(col);


            }
            while (rs.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    // System.out.println(rs.getString(i));

                    row.add(rs.getString(i));
                }


                guestInfo.add(row);
            }

            //FINALLY ADDED TO TableView

            table.setItems(guestInfo);

        } catch (Exception ex) {
            //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    @FXML
    void sarch1(ActionEvent event) {
        try {
            table.getColumns().clear();
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // OracleDataSource ods = new OracleDataSource();
            /// ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##sojodmasa", "123456");
            Statement stm = con.createStatement();
            String insQury;
            if(!sn.getText().isEmpty())
                insQury = "select * From visit where visitID= '" + sn.getText() + "'";
            else insQury = "select * from visit";
            ResultSet rs = stm.executeQuery(insQury);
            guestInfo = FXCollections.observableArrayList();



            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));

                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });


                table.getColumns().addAll(col);


            }
            while (rs.next()) {
                //Iterate Row

                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column


                    row.add(rs.getString(i));
                }


                guestInfo.add(row);
            }

            //FINALLY ADDED TO TableView

            table.setItems(guestInfo);

        } catch (Exception ex) {
            //  Logger.getLogger(Sign_upController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }

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


}
