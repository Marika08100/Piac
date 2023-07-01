import java.util.List;

public record Items(String name,
                    String unit,
                    double price,
                    boolean isOfficialPrice,
                    Category category,
                    List<String> placesOfPurchase,
                    List<String> seasons) {


}
