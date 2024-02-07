package com.ultimateqa.library;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestCase {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        try{
            // Chromedriver executable path
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

            // WebDriver initialization
            driver = new ChromeDriver();

            // Set window dimension
            driver.manage().window().setSize(new Dimension(1700, 1080));
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Webdriver cannot be initialized");
        }
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
