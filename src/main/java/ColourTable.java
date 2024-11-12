import java.util.ArrayList;

public class ColourTable {

    private final int capacity;
    private final ArrayList<ArrayList<Integer>> colours;


    public ColourTable(int capacity){
        if ( capacity <= 1 || (capacity & (capacity -1 )) != 0) {
            throw new IllegalArgumentException("Capacity has to be a Power of 2");
        }

        this.capacity = capacity;
        this.colours = new ArrayList<ArrayList<Integer>>(capacity);
    }

    public void add(ArrayList<Integer> colour) {
        for (Integer bit : colour) {
            if (bit > 255 || bit < 0) {
                throw new IllegalStateException("Colour must be a value between 0 and 255");
            }
        }

        if (colours.size() >= capacity) {
            throw new IllegalStateException("Cannot add more colours. Capacity Reached");
        }

        colours.add(colour);
        System.out.println("ColourTable: " + colours.toString());
    }

    public int size(){
        return colours.size();
    }
}
