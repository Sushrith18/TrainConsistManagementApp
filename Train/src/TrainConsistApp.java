import java.util.*;
import java.util.stream.Collectors;

// Bogie class (extended with type)
class Bogie {
    String name;
    int capacity;
    String type; // Passenger or Goods

    public Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ", Type: " + type + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ---------------- UC7/UC8 Data ----------------
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 60, "Passenger"));
        bogies.add(new Bogie("First Class", 24, "Passenger"));
        bogies.add(new Bogie("Cargo Rectangular", 1000, "Goods"));
        bogies.add(new Bogie("Cargo Cylindrical", 1200, "Goods"));
        bogies.add(new Bogie("Sleeper", 72, "Passenger")); // duplicate type

        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        // ---------------- UC9 (Grouping) ----------------
        Map<String, List<Bogie>> groupedBogies = bogies
                .stream()
                .collect(Collectors.groupingBy(b -> b.type));

        System.out.println("\nGrouped Bogies by Type:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\n" + entry.getKey() + " Bogies:");
            entry.getValue().forEach(System.out::println);
        }

        System.out.println("\nSystem ready for further operations...");
    }
}