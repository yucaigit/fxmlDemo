package com.lyzd.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;

public class IndexController {
    private RunClass runClass;

    @FXML
    private TabController tabController;
    @FXML
    private MainController mainController;


    @FXML
    private void initialize() {
        tabController.injetIndexController(this);
        mainController.injetIndexController(this);
    }

    public void setMain(RunClass runClass) {
        this.runClass = runClass;
    }

    Label getLabe(){return mainController.getLable();
    }
    private MainController banckMain(){return mainController;}

    public void setDate(){mainController.getAll();
    }

    public void showAdd() throws IOException {
        System.out.println("showAddHtml");
        runClass.showAdd();
    }
    public void showIndex() throws IOException {
        System.out.println("---------------");
        runClass.showIndex();
    }
}
