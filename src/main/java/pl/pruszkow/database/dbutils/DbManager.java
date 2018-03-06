package pl.pruszkow.database.dbutils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.pruszkow.database.models.Building;
import pl.pruszkow.database.models.Samples;
import pl.pruszkow.database.models.Location;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./GlassolutionsDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;

    public static void iniDatabase(){
    createConnectionSource();
    //dropTable();
    createTable();
    closeConnectionSourse();
    }

    private static void createConnectionSource(){
        try {
            connectionSource= new JdbcConnectionSource(JDBC_DRIVER_HD,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSourse(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, Location.class);
            TableUtils.createTableIfNotExists(connectionSource, Building.class);
            TableUtils.createTableIfNotExists(connectionSource, Samples.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable(){
        try {
            TableUtils.dropTable(connectionSource,Location.class, true);
            TableUtils.dropTable(connectionSource, Building.class, true);
            TableUtils.dropTable(connectionSource, Samples.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
