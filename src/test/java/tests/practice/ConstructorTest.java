package tests.practice;

import library.modules.practice.constructor.FootballPlayers;
import org.junit.Test;

public class ConstructorTest {
    @Test
    public void constructorTest(){
        FootballPlayers footballPlayers = new FootballPlayers(
                "Lisandro", "Martinez", 26, "Argentina", "Manchester United");

        footballPlayers.displayMessage();
    }
}
