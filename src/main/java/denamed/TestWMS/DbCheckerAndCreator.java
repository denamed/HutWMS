package denamed.TestWMS;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DbCheckerAndCreator {
    public static boolean dbExist(String dbname) {
        File file = new File(dbname);
        if (file.exists() && !file.isDirectory()) {
            System.out.println("Database file found...");
            return true;
        } else {
            System.out.println("Database file not exist!!");
            return false;
        }
    }

    public static void dbCreate(String dbname){
        if (dbExist(dbname)) {
            ;
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
                Connection connection = DriverManager.getConnection("jdbc:sqlite:"+dbname);
                Statement statement = connection.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS Dummy (dummy VARCHAR(5));";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database " + dbname + " is created.");
        }
    }
}
