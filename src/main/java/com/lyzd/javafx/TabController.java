package com.lyzd.javafx;

import com.lyzd.javafx.datasource.DataSources;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class TabController {
    private IndexController indexController;

    public void findAll(ActionEvent event) {
        this.indexController.setDate();
    }
    public void exit(ActionEvent event) {
        Platform.exit();
    }


    public void injetIndexController(IndexController indexController) {
        this.indexController = indexController;
    }


    //得到测试Lable
    public Label getLable(){
        return this.indexController.getLabe();
    }

    public void testf(ActionEvent event) {
        Label lable = getLable();
        String text = lable.getText();
        lable.setText("测试标签");
    }
}
