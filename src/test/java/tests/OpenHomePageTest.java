package tests;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import org.junit.Test;


public class OpenHomePageTest extends TestCase {

    @Test
    public void openPageTest() {
        driver.get(ConfigLoader.getProperty("baseUrl"));

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
