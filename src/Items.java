import java.util.List;

public record Items(String nev,
                    String unit,
                    double price,
                    boolean isOfficialPrice,
                    Category category,
                    List<String> placesOfPurchase ) {
}
