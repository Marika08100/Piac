import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    parts.length > 5 ? List.of(parts[5]) : new ArrayList<>(),
                    parts.length > 6 ? List.of(parts[6]) : new ArrayList<>()
            ));
        }
        for (var actual : items) {
            System.out.println(actual);
        }

        int officialPrice = 0;
        for (var actual : items) {
            if (actual.isOfficialPrice()) {
                officialPrice++;
            }
        }
        System.out.println("Number of official price products: " + officialPrice);

        int saltyPcs = 0;
        int sweetPcs = 0;
        for (var actual : items) {
            if (actual.category().equals(Category.SALTY)) {
                saltyPcs++;
            }
            if (actual.category().equals(Category.SWEET)) {
                sweetPcs++;
            }

        }
        System.out.println("Proportion of salty products: " + (double) saltyPcs / items.size());
        System.out.println("Proportion of sweet products: " + (double) sweetPcs / items.size());


        Items mostExpensive = items.get(0);
        Items cheapest = items.get(0);
        for (var actual : items) {
            if (actual.price() > mostExpensive.price()) {
                mostExpensive = actual;
            }
            if (actual.price() < cheapest.price()) {
                cheapest = actual;
            }
        }
        System.out.println("Legdrágább termék: " + mostExpensive.name() + " - Ár:" + mostExpensive.price() + "Ft");
        System.out.println("Legolcsóbb termék: " + cheapest.name() + " - Ár:" + cheapest.price() + "Ft ");

        Map<String,Integer> countPlaces = new HashMap<>();
        for(var actual : items){
            List<String> placesOfPurchase = actual.placesOfPurchase();
            for(String place : placesOfPurchase){
                countPlaces.put(place,countPlaces.getOrDefault(place,0) +1);
            }
        }
        int maxItem = 0;
        String mostPlace = "";
        for(Map.Entry<String,Integer> entry : countPlaces.entrySet()){
            if(entry.getValue() > maxItem){
                maxItem = entry.getValue();
                mostPlace = entry.getKey();;
            }
        }
        System.out.println("Legtöbb helyen kapható termék száma: " + maxItem);
        System.out.println("Az elérhető legtöbb hely: " + mostPlace);


    }
}