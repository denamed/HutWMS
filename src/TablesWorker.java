import java.sql.*;
import java.util.ArrayList;

public class TablesWorker {
    public static ArrayList<String> readTable(String tableName, String keyName, String keyValue){
        ArrayList<String> list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");  // Class creation for driver which used for database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");  // Perform connection to database
//            Statement statement = connection.createStatement();  // Creation of statement for connection
            String sql = String.format("SELECT * FROM %s WHERE %s = '%s'", tableName, keyName, keyValue);  // Preparing query text
            PreparedStatement preparedStatement = connection.prepareStatement(sql);  // Prepare statement of query for reques
            ResultSet result = preparedStatement.executeQuery();  // Executing the query and store result to "result" variable

            while (result.next()){  // parsing the result into the array "list"
                int columns = result.getMetaData().getColumnCount();
                for (int i = 0; i < columns; i++){
                    list.add(result.getString(i+1));
                }
            }
//            statement.close();  // closing the statement
            connection.close();  // closing the connection
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return list;
    }

    public static void createTable(String tableName, String[] keys, String[] types) {
        if(keys.length!=types.length) {
            System.out.println("Incorrect amount of arguments in table creator");
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
                Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
                Statement statement = connection.createStatement();
                String sql = String.format("CREATE TABLE " + tableName);
                for (int i = 0; i < keys.length; i++) {
                    if (i == 0) {
                        sql = sql + String.format(" ( %s %s", keys[i], types[i]);
                    } else {
                        sql = sql + String.format(",%s %s", keys[i], types[i]);
                    }
                }
                sql = sql + ");";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Done.");
        }
    }

//    public static void updateTable
}
