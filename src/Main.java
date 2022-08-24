import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> set = TablesWorker.readTable("Stock", "id", "13");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
