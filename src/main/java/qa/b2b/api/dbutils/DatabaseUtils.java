package qa.b2b.api.dbutils;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseUtils {
    public static Connection connect;

    /**
     * This method will connect the database connection
     */
    public static void connectToDB() {
        try {
            Driver dbDriver = new Driver();
            DriverManager.registerDriver(dbDriver);
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb",
                    "postgres", "123");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    /**
     * This method will disconnect the database connection
     * @throws SQLException
     */
    public static void disConnectToDB() throws SQLException {
        connect.close();
    }

    /**
     * This methods returns all the data from database
     * @param query
     * @return
     */
    public ResultSet getAllData(String query) {
        ResultSet result = null;
        try {
            result = connect.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This method will validate the data and return the data
     * @param query
     * @param expectedData
     * @param columnind
     * @return
     * @throws SQLException
     */
    public String getTheDataFromDatabaseAndVerify(String query, String expectedData, int columnind) throws SQLException {
        ResultSet result = connect.createStatement().executeQuery(query);
        String actualData = null;
        while (result.next()) {
            //	System.out.println(result.getString(columnind));
            if (result.getString(columnind).equals(expectedData)) {
                actualData = result.getString(columnind);
            }
        }
        return actualData;

    }

    /**
     * This method will validate the data and return the data
     * @param query
     * @param columnindex
     * @param expectedData
     * @return
     * @throws SQLException
     */
    public String getTheDataFromDatabaseAndVerify(String query, int columnindex, String expectedData) throws SQLException {
        ResultSet result = connect.createStatement().executeQuery(query);
        boolean flag = false;
        String actualData = null;
        while (result.next()) {
            try {
                if (result.getString(columnindex).equals(expectedData)) {
                    System.out.println(result.getString(columnindex));
                    flag = true;
                    actualData = result.getString(columnindex);
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (flag) {
            System.out.println("Data is verified and present");
        } else {
            System.out.println("Data is not present");
        }
        return actualData;
    }
}
