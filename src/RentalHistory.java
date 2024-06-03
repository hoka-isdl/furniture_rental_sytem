import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalHistory {
    private static int rentalCount = 0;
    public int id;
    public int userId;
    private int furnitureId;
    private String startedAt;
    private String endedAt;
    public static List<RentalHistory> rentalHistories = new ArrayList<>();

    public RentalHistory(int userId, int furnitureId, String startedAt) {
        this.id = ++rentalCount;
        this.userId = userId;
        this.furnitureId = furnitureId;
        this.startedAt = startedAt;
        this.endedAt = LocalDate.parse(startedAt).plusYears(1).toString();
    }

    public void rent() {
        rentalHistories.add(this);
        System.out.println("Rental started: " + this);
    }

    public void returnRental() {
        this.endedAt = LocalDate.now().toString();
        System.out.println("Rental ended: " + this);
    }

    public static void displayRentalsByUser(String userName) {
        User user = User.findByName(userName);
        if (user == null) {
            System.out.println("User not found: " + userName);
            return;
        }

        System.out.println("Rental History for User: " + userName);
        for (RentalHistory rental : rentalHistories) {
            if (rental.userId == user.id) {
                System.out.println(rental);
            }
        }
    }

    @Override
    public String toString() {
        return "RentalHistory{id=" + id + ", userId=" + userId + ", furnitureId=" + furnitureId + ", startedAt='" + startedAt + "', endedAt='" + endedAt + "'}";
    }
}
