import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /* if U want to create db and first table, then just uncomment next block */

//        String[] keys = {"id", "palletid", "area", "rack", "xcoord", "ycoord", "zcoord"};
//        String[] types = {"INTEGER PRIMARY KEY AUTOINCREMENT", "TEXT", "TEXT", "INTEGER", "INTEGER", "INTEGER", "INTEGER"};
//        TablesWorker.createTable("Stock", keys, types);

        ArrayList<String> set = TablesWorker.readTable("Stock", "id", "1");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
