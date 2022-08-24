import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
//        ResultSet result = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            statement = connection.createStatement();

            String sql = """
                    SELECT * FROM Stock
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String pid = result.getString("palletid");
                String area = result.getString("area");
                System.out.println(id + " " + pid + " " + area);
            }
            statement.close();
            connection.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
