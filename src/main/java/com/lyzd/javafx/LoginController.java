package com.lyzd.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;

public class LoginController {

    private RunClass runClass;

    @FXML
    private TextField userNameFiled;
    @FXML
    private PasswordField passWord;
    @FXML
    private Label tip;
    @FXML
    public void test() throws IOException {

    }

    public void userLogin() throws IOException {
        if (userNameFiled.getText().equals("123")&&passWord.getText().equals("123"))
            runClass.showIndex();
        tip.setText("输入信息错误");
        userNameFiled.setText("");
        passWord.setText("");
        //delete
    }

    public void cancel(){
        userNameFiled.setText("");
        passWord.setText("");
    }

    public void setMain(RunClass runClass){
        this.runClass = runClass;
    }

    @FXML
    public void buttonClicked(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()){
            //左击事件
            case PRIMARY:
                System.out.println("左击事件");
                break;
            case SECONDARY:
                System.out.println("右点击事件");
                break;
            default:
                break;
        }
    }
}
