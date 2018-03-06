package pl.pruszkow.modelfx;

import com.j256.ormlite.dao.DaoManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pruszkow.database.dao.LocationDao;
import pl.pruszkow.database.dbutils.DbManager;
import pl.pruszkow.database.models.Location;
import java.util.List;


public class LocationModel {

    private ObservableList<LocationFx> locationList = FXCollections.observableArrayList();
    private ObjectProperty<LocationFx> location = new SimpleObjectProperty<>();


    public void init(){
        LocationDao locationDao = new LocationDao(DbManager.getConnectionSource());
        List<Location> locations = locationDao.queryForAll(Location.class);
        this.locationList.clear();
        locations.forEach( c->{
            LocationFx locationFx = new LocationFx();
            locationFx.setId(c.getId());
            locationFx.setLocation(c.getLocation());
            this.locationList.add(locationFx);
        });
        DbManager.closeConnectionSourse();
    }

    public  void deleteById(){
        LocationDao locationDao = new LocationDao(DbManager.getConnectionSource());
        locationDao.deleteById(Location.class, location.getValue().getId());
        DbManager.closeConnectionSourse();
        init();
    }

    public void saveLocationInDatabase (String name){
        LocationDao locationDao = new LocationDao(DbManager.getConnectionSource());
        Location location = new Location();
        location.setLocation(name);
        locationDao.creatOrUpdate(location);
        DbManager.closeConnectionSourse();
        init();
    }

    public void updateLocationInDataBase() {
        LocationDao locationDao = new LocationDao(DbManager.getConnectionSource());
        Location tempLocation = locationDao.fineById(Location.class, getLocation().getId());
        tempLocation.setLocation(getLocation().getLocation());
        locationDao.creatOrUpdate(tempLocation);
        DbManager.closeConnectionSourse();
        init();
    }

    public ObservableList<LocationFx> getLocationList() {
        return locationList;
    }

    public void setLocationList(ObservableList<LocationFx> locationList) {
        this.locationList = locationList;
    }

    public LocationFx getLocation() {
        return location.get();
    }

    public ObjectProperty<LocationFx> locationProperty() {
        return location;
    }

    public void setLocation(LocationFx location) {
        this.location.set(location);
    }


}
