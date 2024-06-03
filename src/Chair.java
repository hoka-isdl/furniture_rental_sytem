public class Chair extends Furniture {
    private boolean hasArmrest;

    public Chair(String name, int size, boolean hasArmrest) {
        super(name, size);
        this.hasArmrest = hasArmrest;
    }

    @Override
    public String toString() {
        return "Chair{id=" + id + ", name='" + name + "', size=" + size + ", hasArmrest=" + hasArmrest + "}";
    }
}
