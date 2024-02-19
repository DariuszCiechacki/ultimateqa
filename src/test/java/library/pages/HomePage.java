package library.pages;

import library.Driver;
import library.pages.automation.*;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Driver {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@id='Automation_Practice']")));

        return this;
    }

    public ComplicatedPage navigateToComplicatedPage(){
        driver.findElement(By.xpath("//a[contains(@href,'complicated-page')]"))
                .click();

        return new ComplicatedPage(driver);
    }

    public FakeLandingPage navigateToFakeLandingPage(){
        driver.findElement(By.xpath("//a[contains(@href,'fake-landing-page')]"))
                .click();

        return new FakeLandingPage(driver);
    }

    public FakePricingPage navigateToFakePricingPage(){
        driver.findElement(By.xpath("//a[contains(@href,'fake-pricing-page')]"))
                .click();

        return new FakePricingPage(driver);
    }

    public FillingOutFormsPage navigateToFillingOutFormsPage(){
        driver.findElement(By.xpath("//a[contains(@href,'filling-out-forms')]"))
                .click();

        return new FillingOutFormsPage(driver);
    }

    public SimpleHtmlElementsPage navigateSimpleHtmlElementsPage(){
        driver.findElement(By.xpath("//a[contains(@href,'simple-html-elements-for-automation')]"))
                .click();

        return new SimpleHtmlElementsPage(driver);
    }
}
