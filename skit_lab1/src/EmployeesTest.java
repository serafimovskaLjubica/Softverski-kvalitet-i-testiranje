import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeesTest {

    //unikatni
    @Test

    void MemberInOnlyOneTeam(){

        Set<String> team1 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{"1","2","4"}));

        Set<String> team2 = new HashSet<String>();
        team2.addAll(Arrays.asList(new String[]{"1","2","3"}));

        Employees employees=new Employees();

        Set<String> expected=new HashSet<String>();
        expected.addAll(Arrays.asList(new String[]{"3","4"}));
        assertEquals(expected, employees.notInBothTeams(team1,team2));
    }
    //site se duplikati
    @Test
    void NoMembersInOnlyOneTeam(){
        Set<String> team1 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{"1","2","3"}));

        Set<String> team2 = new HashSet<String>();
        team2.addAll(Arrays.asList(new String[]{"3","2","1"}));

        assertThrows(IllegalArgumentException.class, ()->{
         Employees employees = new Employees();
         employees.notInBothTeams(team1,team2);
        });
    }

    @Test
    void Team1_empty(){
        Set<String> team1 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{}));

        Set<String> team2 = new HashSet<String>();
        team2.addAll(Arrays.asList(new String[]{"1","2","3"}));

        Employees employees=new Employees();

        Set<String> expected=new HashSet<String>();
        expected.addAll(Arrays.asList(new String[]{"1","2","3"}));
        assertEquals(expected, employees.notInBothTeams(team1,team2));
    }

    @Test
    void Team2_empty(){
        Set<String> team1 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{"1","2","4"}));

        Set<String> team2 = new HashSet<String>();
        team2.addAll(Arrays.asList(new String[]{}));

        Employees employees=new Employees();

        Set<String> expected=new HashSet<String>();
        expected.addAll(Arrays.asList(new String[]{"1","2","4"}));
        assertEquals(expected, employees.notInBothTeams(team1,team2));
    }

    @Test

    void Team1_isNull(){
        Set<String> team2 = new HashSet<String>();
        team2.addAll(Arrays.asList(new String[]{"1","2","3"}));
        assertThrows(NullPointerException.class, () ->{
            Employees employees= new Employees();
            employees.notInBothTeams(null,team2);

        } );

    }


    @Test
    void Team2_isNull(){
        Set<String> team1 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{"1","2","4"}));
        assertThrows(NullPointerException.class, () ->{
            Employees employees= new Employees();
            employees.notInBothTeams(team1,null);

        } );

    }

    @Test

    public void EmptyTeams(){

        Set<String> team1 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{}));
        Set<String> team2 = new HashSet<String>();
        team1.addAll(Arrays.asList(new String[]{}));


        assertThrows(IllegalArgumentException.class, () ->{
            Employees employees= new Employees();
            employees.notInBothTeams(team1,team2);

        } );

    }

    @Test

    void BothSetsAreNull(){
        assertThrows(NullPointerException.class, () -> {
            Employees employees = new Employees();
            employees.notInBothTeams(null,null);

        });
    }


}