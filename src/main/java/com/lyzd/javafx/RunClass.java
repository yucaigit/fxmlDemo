package com.lyzd.javafx;

import com.lyzd.javafx.datasource.DataSources;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
public class RunClass extends Application {
    private Stage stage;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            //
            showLogin();
            primaryStage.show();
        }catch (Exception e){e.printStackTrace();}
    }


    public Object switchView(String FxmlUrl) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        //
        loader.setLocation(RunClass.class.getResource(FxmlUrl));
        System.out.println(loader.getLocation());
        AnchorPane ap = loader.load();
        scene = new Scene(ap);
        stage.setScene(scene);
//
        stage.setResizable(false);
        return loader.getController();
    }

    public void showLogin() throws IOException {
        LoginController loginController = (LoginController) switchView("/Login.fxml");
        loginController.setMain(this);
    }

    public void showIndex() throws IOException {
        IndexController indexController = (IndexController) switchView("/Index.fxml");
        indexController.setMain(this);
    }
    public void showAdd() throws IOException {
        MainController mainController = (MainController) switchView("/Add.fxml");
        mainController.setMain(this);
    }
}
