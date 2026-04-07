
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class TrainConsistAppTest {

    // Helper method to create sample data
    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        return bogies;
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = getSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = getSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // AC Chair = 60 → should NOT be included
        assertFalse(result.stream().anyMatch(b -> b.name.equals("AC Chair")));
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = getSampleBogies();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertFalse(result.stream().anyMatch(b -> b.name.equals("First Class")));
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Super Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = getSampleBogies();

        bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Original list should remain unchanged
        assertEquals(3, bogies.size());
    }
}