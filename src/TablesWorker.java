import java.sql.*;
import java.util.ArrayList;

public class TablesWorker {
    public static ArrayList<String> readTable(String table, String key, String value){
        ArrayList<String> list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");  // Class creation for driver which used for database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");  // Perform connection to database
            Statement statement = connection.createStatement();  // Creation of statement for connection
            String sql = String.format("SELECT * FROM %s WHERE %s = %s", table, key, value);  // Preparing query text
            PreparedStatement preparedStatement = connection.prepareStatement(sql);  // Prepare statement of query for reques
            ResultSet result = preparedStatement.executeQuery();  // Executing the query and store result to "result" variable
            while (result.next()){
                int columns = result.getMetaData().getColumnCount();
                for (int i = 0; i < columns; i++){
                    list.add(result.getString(i+1));
                }
            }
            statement.close();  // closing the statement
            connection.close();  // closing the connection
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return list;
    }
}
