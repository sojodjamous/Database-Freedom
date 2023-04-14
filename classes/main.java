package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



import java.io.IOException;

public class main extends Application
{
    public static Stage mainStage=new Stage();
    public static void main(String [] args){
        launch(args);

    }
    @Override
    public void start(Stage stage) throws IOException
    {

        Parent root= FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
        stage.setTitle("Freedom Tunnel");
        Scene scene=new Scene(root, 900, 510);
        Image image=new Image(("image/3.jpeg"));
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();

    }


    }

