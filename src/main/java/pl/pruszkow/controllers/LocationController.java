package pl.pruszkow.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.pruszkow.modelfx.LocationFx;
import pl.pruszkow.modelfx.LocationModel;
import pl.pruszkow.utils.DialogsUtils;

public class LocationController {

    @FXML
    private Button addLocationButton;

    @FXML
    private Button deleteLocationButton;

    @FXML
    private Button editLocationButton;

    @FXML
    private TextField locationTextField;

    @FXML
    private ComboBox<LocationFx> locationComboBox;

    private LocationModel locationModel;

    @FXML
    private void initialize() {
        this.locationModel = new LocationModel();
        this.locationModel.init();
        this.locationComboBox.setItems(this.locationModel.getLocationList());
        initBindings();
    }

    private void initBindings() {
        this.addLocationButton.disableProperty().bind(locationTextField.textProperty().isEmpty());
        //jeżeli pole jest wypełnione - > disableProperty true [przycis jest włączony]
        this.deleteLocationButton.disableProperty().bind(this.locationModel.locationProperty().isNull());
        this.editLocationButton.disableProperty().bind(this.locationModel.locationProperty().isNull());
    }

    public void addLocationOnAction() {
        //locationTextField.getText();
        locationModel.saveLocationInDatabase(locationTextField.getText());
        locationTextField.clear();
    }

    public void deleteLocationOnAction() {
        this.locationModel.deleteById();
    }

    public void onActionComboBox() {
        this.locationModel.setLocation(this.locationComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditLocation() {
        String newLocationName = DialogsUtils.editDialog(this.locationModel.getLocation().getLocation());
        if(newLocationName!= null){
            this.locationModel.getLocation().setLocation(newLocationName);
            this.locationModel.updateLocationInDataBase();
        }
    }
}
