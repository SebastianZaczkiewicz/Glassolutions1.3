package pl.pruszkow.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String STOCK_FXML = "/fxml/Stock.fxml";
    public static final String ISSUANCE_FXML = "/fxml/Issuance.fxml";
    public static final String RECEPTION_FXML = "/fxml/Reception.fxml";
    public static final String LOCATION_FXML = "/fxml/Location.fxml";
    public static final String ADD_LOCATION_FXML = "/fxml/AddLocation.fxml";

    private MainController mainController;

    @FXML
    private ToggleGroup ToggleButonGrops;
    @FXML
    public void TopButtonStock() {
        mainController.setCenter(STOCK_FXML);
    }
    @FXML
    public void TopButtonIssuance() {
        mainController.setCenter(ISSUANCE_FXML);
    }
    @FXML
    public void TopButtonRecetion() {
        mainController.setCenter(RECEPTION_FXML);
    }
    @FXML
    public void TopButtonLocation() {
        mainController.setCenter(LOCATION_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void addLocation() {
        if(ToggleButonGrops.getSelectedToggle()!=null){
            ToggleButonGrops.getSelectedToggle().setSelected(false);
        }
        mainController.setCenter(ADD_LOCATION_FXML);
    }
}
