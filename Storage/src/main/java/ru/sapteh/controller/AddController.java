package ru.sapteh.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.RadioElements;
import ru.sapteh.service.RadioElementsService;

public class AddController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<RadioElements, Integer> dao = new RadioElementsService(factory);
    RadioElements radioElements = new RadioElements();

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldManufacturer;

    @FXML
    private TextField textFieldDescription;

    @FXML
    private TextField textFieldQuantity;

    @FXML
    private TextField textFieldCost;

    @FXML
    private Button buttonAdd;

    @FXML
    void onActionAdd(ActionEvent event) {
        radioElements.setName(textFieldName.getText());
        radioElements.setManufacturer(textFieldManufacturer.getText());
        radioElements.setDescription(textFieldDescription.getText());
        radioElements.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
        radioElements.setCost(textFieldCost.getText());

        dao.create(radioElements);
    }

}
