import java.util.HashSet;
import java.util.Set;

public class Employees {
    public static Set<String> notInBothTeams(Set<String> team1, Set<String> team2){

        if(team1==null || team2==null){
            throw new NullPointerException("Parametar is null");
        }

        if(team1.isEmpty() && team2.isEmpty()){

            throw new IllegalArgumentException("Both teams are empty");
        }
        Set<String> Team1MembersOnly = new HashSet<String>();
        for (String i : team1) {
            if (!(team2.contains(i))) {
                Team1MembersOnly.add(i);
            }
        }

        Set<String> Team2MembersOnly = new HashSet<String>();
        for (String j : team2) {
            if (!(team1.contains(j))) {
                Team2MembersOnly.add(j);
            }
        }

        Set<String> merged = new HashSet<String>(Team1MembersOnly);
        merged.addAll(Team2MembersOnly);
        if(merged.isEmpty()){
            throw new IllegalArgumentException("Every employee works in both teams");
        }
        return merged;

    }
}
