package pl.pruszkow.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "BUILDING")
public class Building implements BaseModel{
    public Building(){
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "BUILDING",canBeNull = false)
    private String building;

    @DatabaseField(columnName = "SHORCUT")
    private String shortcut;

    @DatabaseField(columnName ="INFO_BUILDING")
    private String infoBuilding;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Samples> samples;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getBuilding() { return building; }

    public void setBuilding(String building) { this.building = building; }

    public String getShortcut() { return shortcut; }

    public void setShortcut(String shortcut) { this.shortcut = shortcut; }

    public String getInfoBuilding() { return infoBuilding; }

    public void setInfoBuilding(String infoBuilding) { this.infoBuilding = infoBuilding; }

    public ForeignCollection<Samples> getSamples() { return samples; }

    public void setSamples(ForeignCollection<Samples> samples) { this.samples = samples; }
}
