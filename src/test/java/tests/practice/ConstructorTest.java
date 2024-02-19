package tests.practice;

import library.modules.practice.constructor.FootballPlayers;
import org.junit.Test;

public class ConstructorTest {
    String firstName = "Lisandro";
    String lastName = "Martinez";
    int age = 26;
    String footballClub = "Manchester United";
    int clubAppearances = 10;
    int nationalAppearances = 10;

    @Test
    public void constructorTest(){
        FootballPlayers footballPlayers = new FootballPlayers(
                firstName, lastName, age, footballClub);

        footballPlayers.displayMessage();
        footballPlayers.hobby();
        footballPlayers.appearances(clubAppearances, nationalAppearances, 13);
        footballPlayers.appearances(clubAppearances, nationalAppearances);
    }
}
