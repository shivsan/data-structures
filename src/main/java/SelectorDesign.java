import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'getSelectionStatus' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY applications as parameter.
     */

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {


        return null;
    }
}

public class SelectorDesign {
    // Get all candidates - check
    // Filter unfit candidates - check
    // Group into striker or Defender or None - check
    // Rank Strikers, Defenders - check
    // If one group has more than the other, try to add players from the NONE category into the insufficient team
    // and trim by rank to make both groups equal
    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        FilterService filterService = new FilterService(5.8f, 23f, 50, 30);
        List<Player> allPlayers;
        List<Player> defenders = new ArrayList<>();
        List<Player> strikers = new ArrayList<>();
        List<Player> none = new ArrayList<>();

        allPlayers = applications
                .stream()
                .map(application -> new Player(application.get(0), application.get(1), (application.get(2)), (application.get(3)), (application.get(4)))).collect(Collectors.toList());

        allPlayers.forEach(player -> player.setSelected(filterService.passes(player) ? Selected.SELECT : Selected.REJECT));

        allPlayers.stream()
                .filter(Player::isSelected)
                .forEach(
                        player -> {
//                            switch (player.getProposedCategory()) {
//                                case DEFENDER:
//                                    defenders.add(player);
//                                    player.setFinalPosition(PlayerPosition.DEFENDER);
//                                case STRIKER:
//                                    strikers.add(player);
//                                    player.setFinalPosition(PlayerPosition.STRIKER);
//                                case NONE:
//                                    none.add(player);
//                                    player.setFinalPosition(PlayerPosition.NONE);
//                            }

                            if (filterService.passesDefender(player) && filterService.passesStriker(player)) {
                                none.add(player);
                                player.setFinalPosition(PlayerPosition.NONE);
                            } else if (filterService.passesDefender(player)) {
                                defenders.add(player);
                                player.setFinalPosition(PlayerPosition.DEFENDER);
                            } else if (filterService.passesStriker(player)) {
                                strikers.add(player);
                                player.setFinalPosition(PlayerPosition.STRIKER);
                            } else if (!filterService.passesStriker(player) && !filterService.passesStriker(player)) {
                                player.setSelected(Selected.REJECT);
                            }
                        }
                );

        defenders.sort(new PlayerComparator());
        strikers.sort(new PlayerComparator());
        none.sort(new PlayerComparator());

        if (defenders.size() != strikers.size()) {
            List<Player> smallerGroup = defenders.size() < strikers.size() ? defenders : strikers;
            List<Player> largerGroup = defenders.size() > strikers.size() ? defenders : strikers;
//            final PlayerPosition finalPositionOfSmallerGroup = smallerGroup.get(0).finalPosition;
//
//            // Change NONE to smallerGroup category
//            none.forEach(nonePlayer -> {
//                nonePlayer.setFinalPosition(finalPositionOfSmallerGroup);
//            }); // Optional, can smallergroup be zero?

//            smallerGroup.addAll(none);
//            smallerGroup.sort(new PlayerComparator()); // or trim none and then sort???

            if (smallerGroup.size() > largerGroup.size()) {
                List<Player> temp = smallerGroup;
                smallerGroup = largerGroup;
                largerGroup = temp;
            }

            // Trim the larger group
            // Reject the least ranked candidates
            List<Player> finalSelected = largerGroup.subList(0, smallerGroup.size());
            List<Player> finalRejected = largerGroup.subList(smallerGroup.size(), largerGroup.size());

            // Reject the final group
            finalRejected.forEach(player -> player.setSelected(Selected.REJECT));
        } else {
            none.forEach(player -> player.setSelected(Selected.SELECT));
        }

        return allPlayers.stream().map(Player::getOutputList).collect(Collectors.toList());
    }

}

class Player {
    private String name;
    private Selected selected;
    private float height;
    private float bmi;
    int goalsScored;
    int goalsDefended;

    public void setFinalPosition(PlayerPosition finalPosition) {
        this.finalPosition = finalPosition;
    }

    private PlayerPosition finalPosition;

    public String getName() {
        return name;
    }

    public float getHeight() {
        return height;
    }

    public float getBmi() {
        return bmi;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsDefended() {
        return goalsDefended;
    }

    public void setSelected(Selected selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return this.selected == Selected.SELECT;
    }

    public Player(String name, float height, float bmi, int goalsScored, int goalsDefended) {
        this.name = name;
        this.height = height;
        this.bmi = bmi;
        this.goalsScored = goalsScored;
        this.goalsDefended = goalsDefended;
    }

    public Player(String name, String height, String bmi, String goalsScored, String goalsDefended) {
        this.name = name;
        this.height = Float.parseFloat(height);
        this.bmi = Float.parseFloat(bmi);
        this.goalsScored = Integer.parseInt(goalsScored);
        this.goalsDefended = Integer.parseInt(goalsDefended);
    }

    PlayerPosition getProposedCategory() {
        if (goalsScored == goalsDefended)
            return PlayerPosition.NONE;
        if (goalsDefended > goalsScored)
            return PlayerPosition.DEFENDER;
        return PlayerPosition.STRIKER;
    }

    private String getFinalPositionString() {
        if (finalPosition == null || selected == Selected.REJECT)
            return "NA";

        return finalPosition.toString();
    }

    String getOutput() {
        return String.format("%s %s %s", name, selected.toString(), getFinalPositionString());
    }

    List<String> getOutputList() {
        return Arrays.stream(new String[]{name, selected.toString(), getFinalPositionString()}).collect(Collectors.toList());
    }
}

enum PlayerPosition {
    STRIKER,
    DEFENDER,
    NONE
}

enum Selected {
    SELECT,
    REJECT
}

class FilterService {
    private float minHeight;
    private float maxBmi;
    private int minGoalsScored;
    private int minGoalsDefended;

    public FilterService(float minHeight, float maxBmi, int minGoalsScored, int minGoalsDefended) {
        this.minHeight = minHeight;
        this.maxBmi = maxBmi;
        this.minGoalsScored = minGoalsScored;
        this.minGoalsDefended = minGoalsDefended;
    }

    boolean passes(Player player) {
        if (player.getBmi() > maxBmi) return false;
        if (player.getHeight() < minHeight) return false;

        return true;
    }

    boolean passesStriker(Player player) {
        return player.getGoalsScored() >= minGoalsScored;
    }

    boolean passesDefender(Player player) {
        return player.getGoalsDefended() >= minGoalsDefended;
    }
}

class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        // Assumes that the players are in the same category
        if (o1.getProposedCategory() == o2.getProposedCategory())
            switch (o1.getProposedCategory()) {
                case NONE:
                    return -o1.goalsDefended + o2.goalsDefended;
                case STRIKER:
                    return -o1.goalsScored + o1.goalsScored;
                case DEFENDER:
                    return -o1.goalsDefended + o1.goalsDefended;
            }

        return 0;
    }
}