package tests;

import library.TestCase;
import org.junit.Test;


public class OpenPageTest extends TestCase {

    @Test
    public void openPageTest() {
        driver.get("https://ultimateqa.com/automation/");

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
