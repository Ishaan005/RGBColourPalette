import java.util.ArrayList;

public class ColourTable {

    private final int capacity;
    private final ArrayList<Integer> colours;

    //Constructor for ColourTable
    public ColourTable(int capacity){
        //Check ColourTable capacity is a Power of 2
        if ( capacity <= 1 || (capacity & (capacity -1 )) != 0) {
            throw new IllegalArgumentException("Capacity has to be a Power of 2");
        }

        this.capacity = capacity;
        this.colours = new ArrayList<>(capacity);
    }

    //Method to add a RGB colour to ColourTable
    public void add(int colour) {
        //Check colour to add is a 24-bit value of correct range
        if (colour > 0xFFFFFF || colour < 0x000000) {
                throw new IllegalStateException("Color must be a 24-bit RGB value between 0x000000 and 0xFFFFFF");
            }

        if (colours.size() >= capacity) {
            throw new IllegalStateException("Cannot add more colours. Capacity Reached");
        }

        colours.add(colour);
        System.out.println("ColourTable: " + colours);
    }

    //Return size of ColourTable
    public int size(){
        return colours.size();
    }
}
