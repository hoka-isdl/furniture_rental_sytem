public class Table extends Furniture {
    private int numberOfLegs;

    public Table(String name, int size, int numberOfLegs) {
        super(name, size);
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public String toString() {
        return "Table{id=" + id + ", name='" + name + "', size=" + size + ", numberOfLegs=" + numberOfLegs + "}";
    }
}
