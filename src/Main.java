import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Register User");
            System.out.println("2. Register Table");
            System.out.println("3. Register Chair");
            System.out.println("4. Register Refrigerator");
            System.out.println("5. Rent Furniture");
            System.out.println("6. Return Furniture");
            System.out.println("7. Display All Users");
            System.out.println("8. Display All Furnitures");
            System.out.println("9. Display Rentals By User");
            System.out.println("10. Exit");

            try {
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter user name: ");
                        String userName = reader.readLine();
                        System.out.print("Enter user address: ");
                        String userAddress = reader.readLine();
                        User user = new User(userName, userAddress);
                        user.register();
                        break;
                    case 2:
                        System.out.print("Enter table name: ");
                        String tableName = reader.readLine();
                        System.out.print("Enter table size: ");
                        int tableSize = Integer.parseInt(reader.readLine());
                        System.out.print("Enter number of legs: ");
                        int numberOfLegs = Integer.parseInt(reader.readLine());
                        Table table = new Table(tableName, tableSize, numberOfLegs);
                        table.register();
                        break;
                    case 3:
                        System.out.print("Enter chair name: ");
                        String chairName = reader.readLine();
                        System.out.print("Enter chair size: ");
                        int chairSize = Integer.parseInt(reader.readLine());
                        System.out.print("Has armrest (true/false): ");
                        boolean hasArmrest = Boolean.parseBoolean(reader.readLine());
                        Chair chair = new Chair(chairName, chairSize, hasArmrest);
                        chair.register();
                        break;
                    case 4:
                        System.out.print("Enter refrigerator name: ");
                        String refrigeratorName = reader.readLine();
                        System.out.print("Enter refrigerator size: ");
                        int refrigeratorSize = Integer.parseInt(reader.readLine());
                        System.out.print("Enter capacity: ");
                        int capacity = Integer.parseInt(reader.readLine());
                        Refrigerator refrigerator = new Refrigerator(refrigeratorName, refrigeratorSize, capacity);
                        refrigerator.register();
                        break;
                    case 5:
                        System.out.print("Enter user ID: ");
                        int rentUserId = Integer.parseInt(reader.readLine());
                        System.out.print("Enter furniture ID: ");
                        int rentFurnitureId = Integer.parseInt(reader.readLine());
                        System.out.print("Enter start date (YYYY-MM-DD): ");
                        String startDate = reader.readLine();
                        RentalHistory rental = new RentalHistory(rentUserId, rentFurnitureId, startDate);
                        rental.rent();
                        break;
                    case 6:
                        System.out.print("Enter rental ID to return: ");
                        int returnRentalId = Integer.parseInt(reader.readLine());
                        for (RentalHistory r : RentalHistory.rentalHistories) {
                            if (r.id == returnRentalId) {
                                r.returnRental();
                                break;
                            }
                        }
                        break;
                    case 7:
                        User.displayAllUsers();
                        break;
                    case 8:
                        Furniture.displayAllFurnitures();
                        break;
                    case 9:
                        System.out.print("Enter user name to display rentals: ");
                        String rentalUserName = reader.readLine();
                        RentalHistory.displayRentalsByUser(rentalUserName);
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
