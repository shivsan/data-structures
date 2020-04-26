import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectorDesignTest {
    private SelectorDesign selectorDesign;

    @Before
    public void setUp() {
        selectorDesign = new SelectorDesign();
    }

    @Test
    public void shouldPass() {
        List<String> players = Arrays.stream(new String[]{"Boateng 6.1 22 24 45",
                "Kaka 6 22 1 1",
                "Ronaldo 5.8 21 120 0",
                "Suarez 5.9 20 100 1"}).collect(Collectors.toList());
        List<List<String>> playerStats1 = players.stream().map(p -> p.split(" ")).map(ps -> Arrays.stream(ps).collect(Collectors.toList())).collect(Collectors.toList());
        List<List<String>> playerStats = SelectorDesign.getSelectionStatus(playerStats1);
        playerStats.forEach(System.out::println);
    }
}