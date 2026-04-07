import java.util.*;

// Bogie class (OOP Model)
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ---------------- UC7 (Comparator + OOP) ----------------
        List<Bogie> passengerBogies = new ArrayList<>();

        // Create bogie objects
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("\nBefore Sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Sort by capacity (ascending)
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nSystem ready for further operations...");
    }
}