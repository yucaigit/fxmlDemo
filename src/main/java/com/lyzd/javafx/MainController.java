package com.lyzd.javafx;

import com.lyzd.javafx.datasource.DataSources;
import com.lyzd.javafx.datasource.PeopleEntity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class MainController {
    private DataSources dataSources;
    public int targetId;
    public Boolean isDelete = false;
    private IndexController indexController;
    private RunClass runClass;
    @FXML
    private Label test;

    @FXML
    private TableView people;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn age;
    @FXML
    private TableColumn sex;
    @FXML
    private TableColumn job;

    @FXML private TextField inputId;
    @FXML private TextField inputName;
    @FXML private TextField inputAge;
    @FXML private TextField inputSex;
    @FXML private TextField inputJob;
    @FXML Label tip;

    public Label getLable(){return test;}

    public void getAll(){
        System.out.println("进入Main");
        dataSources = new DataSources();
        List<PeopleEntity> all = dataSources.getAll();
        System.out.println(all);
        ObservableList<PeopleEntity> peopleEntities = FXCollections.observableList(all);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        job.setCellValueFactory(new PropertyValueFactory<>("job"));
        people.setItems(peopleEntities);

    }

    @FXML
    public void deletePerson() {
        System.out.println("进入deletePerson");
        if (isDelete)
            System.out.println(targetId);
            dataSources.remove(targetId);
        isDelete = false;
        getAll();
    }
    @FXML
    public void TestA(MouseEvent mouseEvent) {
        switch (mouseEvent.getButton()){
            case PRIMARY:
                isDelete = true;
//                 people.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PeopleEntity>() {
//                    @Override
//                    public void changed(ObservableValue<? extends PeopleEntity> observable, PeopleEntity oldValue, PeopleEntity newValue) {
//                        targetId = newValue.getId();
//                    }
//                });
                PeopleEntity o = (PeopleEntity) people.getSelectionModel().selectedItemProperty().get();
                targetId= o.getId();
                break;
            case SECONDARY:
                System.out.println("Test Right");
                break;
            default:
                break;
        }
    }

    public void injetIndexController(IndexController indexController) {
        this.indexController = indexController;
    }
    public void insertPerson() throws IOException {
        this.indexController.showAdd();
    }

    public Boolean isDigit(String str){
        if (str.equals(""))
            return false;
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++){
            boolean digit = Character.isDigit(chars[i]);
            if (!digit)
                return false;
        }
        return true;
    }
    public void showMessage(String str){
        tip.setText(str);
    }
    public Boolean isNull(String str){
        if (str.equals("") || str==null)
            return true;
        return false;
    }

    public void insert(ActionEvent event) {
        String text = inputId.getText();
        String text1 = inputAge.getText();
        String text2 = inputName.getText();
        String text3 = inputSex.getText();
        String text4 = inputJob.getText();
        if (!isDigit(text)) {
            showMessage("编号类型错误!");
            return;
        }
        if (!isDigit(text1)) {
            showMessage("年龄类型错误");
            return;
        }
        if (!isDigit(text3)){
            showMessage("性别输入1||2");
            return;
        }
        if (isNull(text2)) {
            showMessage("姓名不能为空");
            return;
        }
        if (isNull(text4)) {
            showMessage("职称为空");
            return;
        }
        System.out.println("-----------------------6-------------------");
        tip.setText("");
        PeopleEntity peopleEntity = new PeopleEntity();
        int i = Integer.parseInt(text);
        peopleEntity.setId(i);
        int i1 = Integer.parseInt(text1);
        peopleEntity.setAge(i1);
        int i2 = Integer.parseInt(text3);
        peopleEntity.setSex(i2);
        peopleEntity.setName(text2);
        peopleEntity.setJob(text4);
        System.out.println(peopleEntity);
        DataSources dataSources = new DataSources();
        Boolean add = dataSources.add(peopleEntity);

//        Boolean add = dataSources.add(peopleEntity);
        if (add){
            showMessage("添加成功！");
        }

    }


    public void returnIndex() throws IOException {
        runClass.showIndex();
    }

    public void setMain(RunClass runClass) {
        this.runClass = runClass;
    }
}
