package pl.pruszkow.modelfx;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LocationFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty location = new SimpleStringProperty();

    public int getId() { return id.get(); }

    public IntegerProperty idProperty() { return id; }

    public void setId(int id) { this.id.set(id); }

    public String getLocation() { return location.get(); }

    public StringProperty locationProperty() { return location; }

    public void setLocation(String location) { this.location.set(location); }

    @Override
    public String toString() {
        return location.getValue();

    }
}
