public class Refrigerator extends Furniture {
    private int capacity;

    public Refrigerator(String name, int size, int capacity) {
        super(name, size);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Refrigerator{id=" + id + ", name='" + name + "', size=" + size + ", capacity=" + capacity + "}";
    }
}
