package library.pages;

import library.pages.automation.ComplicatedPage;
import library.pages.automation.FakeLandingPage;
import library.pages.automation.FakePricingPage;
import library.pages.automation.FillingOutFormsPage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import library.pages.user.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static library.Driver.driver;

public class HomePage {
    public static final String homePageTitle = "//span[@id='Automation_Practice']";

    public HomePage waitForHomePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(homePageTitle)));

        return this;
    }

    public ComplicatedPage navigateToComplicatedPage(){
        driver.findElement(By.xpath("//a[contains(@href,'complicated-page')]"))
                .click();

        return new ComplicatedPage();
    }

    public FakeLandingPage navigateToFakeLandingPage(){
        driver.findElement(By.xpath("//a[contains(@href,'fake-landing-page')]"))
                .click();

        return new FakeLandingPage();
    }

    public FakePricingPage navigateToFakePricingPage(){
        driver.findElement(By.xpath("//a[contains(@href,'fake-pricing-page')]"))
                .click();

        return new FakePricingPage();
    }

    public FillingOutFormsPage navigateToFillingOutFormsPage(){
        driver.findElement(By.xpath("//a[contains(@href,'filling-out-forms')]"))
                .click();

        return new FillingOutFormsPage();
    }

    public SimpleElementsPage navigateSimpleHtmlElementsPage(){
        driver.findElement(By.xpath("//a[contains(@href,'simple-html-elements-for-automation')]"))
                .click();

        return new SimpleElementsPage();
    }

    public LoginPage navigateToLoginPage(){
        driver.findElement(By.xpath("//a[contains(@href,'sign_in')]"))
                .click();

        return new LoginPage();
    }
}
