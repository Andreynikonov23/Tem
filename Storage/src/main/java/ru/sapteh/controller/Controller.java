package ru.sapteh.controller;

import javafx.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.RadioElements;
import ru.sapteh.service.RadioElementsService;

import java.io.IOException;

public class Controller {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<RadioElements, Integer> dao = new RadioElementsService(factory);
    private final ObservableList<RadioElements> observableList = FXCollections.observableArrayList();

    @FXML
    private TableView<RadioElements> tableView;

    @FXML
    private TableColumn<RadioElements, Integer> columnId;

    @FXML
    private TableColumn<RadioElements, String> columnName;

    @FXML
    private TableColumn<RadioElements, String> columnManufacturer;

    @FXML
    private TableColumn<RadioElements, String> columnDescription;

    @FXML
    private TableColumn<RadioElements, Integer> columnQuantity;

    @FXML
    private TableColumn<RadioElements, String> columnCost;

    @FXML
    private Button buttonNew;

    @FXML
    void initialize(){
        tableView.setItems(observableList);
        columnId.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        columnName.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getName()));
        columnManufacturer.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getManufacturer()));
        columnDescription.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getDescription()));
        columnQuantity.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getQuantity()));
        columnCost.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getCost()));
        observableList.addAll(dao.findByAll());
    }

    public void onActionNew(ActionEvent event) throws IOException {
        buttonNew.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/add.fxml"));
        Stage stage = new Stage();
        stage.setTitle("ADD");
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
