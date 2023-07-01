import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = FileReaderHandler.fileReader("res/piac.txt");
        List<Items> items = new ArrayList<>();
        for (String line : stringList) {
            String[] parts = line.split(";");
            items.add(new Items(
                    parts[0],
                    parts[1],
                    Double.parseDouble(parts[2]),
                    Boolean.parseBoolean(parts[3]),
                    parts[4].equals("sós") ? Category.SALTY : Category.SWEET,
                    parts.length > 5 ? List.of(parts[5].split(",")) : new ArrayList<>()));

        }
        for (var actual : items) {
            System.out.println(actual);
        }
    }
}