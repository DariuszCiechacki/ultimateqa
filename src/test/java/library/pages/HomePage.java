package library.pages;

import library.pages.automation.ComplicatedPage;
import library.pages.automation.FakeLandingPage;
import library.pages.automation.FillingOutFormsPage;
import library.pages.automation.applifecyclepages.Sprint1Page;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import library.pages.user.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Automation_Practice")
    public WebElement homePageTitleElement;
    @FindBy(xpath = "//a[contains(@href,'complicated-page')]")
    WebElement complicatedPageButton;
    @FindBy(xpath = "//a[contains(@href,'fake-landing-page')]")
    WebElement fakeLandingPageButton;
    @FindBy(xpath = "//a[contains(@href,'application-lifecycle')]")
    WebElement appLifecyclePageButton;
    @FindBy(xpath = "//a[contains(@href,'filling-out-forms')]")
    WebElement fillingOutFormsPageButton;
    @FindBy(xpath = "//a[contains(@href,'simple-html-elements-for-automation')]")
    WebElement simpleElementsPageButton;
    @FindBy(xpath = "//a[contains(@href,'sign_in')]")
    WebElement loginPageButton;

    public HomePage waitForHomePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .elementToBeClickable(homePageTitleElement));

        return this;
    }

    public ComplicatedPage navigateToComplicatedPage(){
        complicatedPageButton.click();

        return new ComplicatedPage();
    }

    public FakeLandingPage navigateToFakeLandingPage(){
        fakeLandingPageButton.click();

        return new FakeLandingPage();
    }

    public Sprint1Page navigateToAppLifecyclePage(){
        appLifecyclePageButton.click();

        return new Sprint1Page();
    }

    public FillingOutFormsPage navigateToFillingOutFormsPage(){
        fillingOutFormsPageButton.click();

        return new FillingOutFormsPage();
    }

    public SimpleElementsPage navigateSimpleElementsPage(){
        simpleElementsPageButton.click();

        return new SimpleElementsPage();
    }

    public LoginPage navigateToLoginPage(){
        loginPageButton.click();

        return new LoginPage();
    }
}
