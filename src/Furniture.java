import java.util.ArrayList;
import java.util.List;

public abstract class Furniture implements CommonEntity {
    private static int furnitureCount = 0;
    protected int id;
    protected String name;
    protected int size;
    private static List<Furniture> furnitures = new ArrayList<>();

    public Furniture(String name, int size) {
        this.id = ++furnitureCount;
        this.name = name;
        this.size = size;
    }

    @Override
    public void register() {
        furnitures.add(this);
        System.out.println("Furniture registered: " + this);
    }

    @Override
    public void delete() {
        furnitures.remove(this);
        System.out.println("Furniture deleted: " + this);
    }

    public int getId() {
        return id;
    }

    public static Furniture findById(int id) {
        for (Furniture furniture : furnitures) {
            if (furniture.id == id) {
                return furniture;
            }
        }
        return null;
    }

    public static void displayAllFurnitures() {
        System.out.println("Furniture List:");
        for (Furniture furniture : furnitures) {
            System.out.println(furniture);
        }
    }

    @Override
    public String toString() {
        return "Furniture{id=" + id + ", name='" + name + "', size=" + size + "}";
    }
}
