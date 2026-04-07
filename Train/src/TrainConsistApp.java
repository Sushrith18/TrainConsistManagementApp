import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // ---------------- UC2 ----------------
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        passengerBogies.remove("AC Chair");

        boolean exists = passengerBogies.contains("Sleeper");

        // ---------------- UC3 ----------------
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // duplicate

        // ---------------- UC4 ----------------
        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        trainConsist.add(2, "Pantry");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // ---------------- UC5 (LinkedHashSet) ----------------
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt duplicate
        formation.add("Sleeper"); // ignored automatically

        System.out.println("\nTrain Formation (Insertion Order Preserved, No Duplicates):");
        System.out.println(formation);

        System.out.println("\nSystem ready for further operations...");
    }
}