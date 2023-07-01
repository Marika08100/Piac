import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderHandler {
    public static List<String> fileReader(String filePath) {
        List<String> strings = new ArrayList<>();
        File file = new File(filePath);
        try {
            Scanner sc = new Scanner(file);
            while ((sc.hasNextLine())) {
                strings.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found!");
        }
        return strings;


    }
}
