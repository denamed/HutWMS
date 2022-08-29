import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Scratch {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();
            String sql = """
                            CREATE TABLE IF NOT EXISTS Dummy
                            (
                               dummy VARCHAR(5)
                            );
                    """;
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database creation done.");
    }
}
