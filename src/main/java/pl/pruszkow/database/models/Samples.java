package pl.pruszkow.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName ="SAMPLES")
public class Samples implements BaseModel {
    public Samples(){
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "BUILIDING_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Building building;

    @DatabaseField(columnName = "LOCATION_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Location location;

    @DatabaseField(columnName = "HEIGHT")
    private int height;

    @DatabaseField(columnName = "WIDTH")
    private int width;

    @DatabaseField(columnName = "QUANTITY")
    private int quantity;

    @DatabaseField(columnName = "ALFAK_ORDER")
    private int alfakOrder;

    @DatabaseField(columnName = "BARCOD")
    private int barcod;

    @DatabaseField(columnName = "SAMPLE_FOR")
    private String SampleFor;

    @DatabaseField(columnName = "ADD_DATE")
    private Date addDate;

    @DatabaseField(columnName = "LOST_DATE")
    private Date lostDate;

    @DatabaseField(columnName = "INFO_SAMPLE")
    private String infoSample;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Building getBuilding() { return building; }

    public void setBuilding(Building building) { this.building = building; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public int getWidth() { return width; }

    public void setWidth(int width) { this.width = width; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getAlfakOrder() { return alfakOrder; }

    public void setAlfakOrder(int alfakOrder) { this.alfakOrder = alfakOrder; }

    public int getBarcod() { return barcod; }

    public void setBarcod(int barcod) { this.barcod = barcod; }

    public String getSampleFor() { return SampleFor; }

    public void setSampleFor(String sampleFor) { SampleFor = sampleFor; }

    public Date getAddDate() { return addDate; }

    public void setAddDate(Date addDate) { this.addDate = addDate; }

    public Date getLostDate() { return lostDate; }

    public void setLostDate(Date lostDate) { this.lostDate = lostDate; }

    public String getInfoSample() { return infoSample; }

    public void setInfoSample(String infoSample) { this.infoSample = infoSample; }

}
