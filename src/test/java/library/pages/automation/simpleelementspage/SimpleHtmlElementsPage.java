package library.pages.automation.simpleelementspage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SimpleHtmlElementsPage extends BasePage {
    public SimpleHtmlElementsPage(WebDriver driver) {
        super(driver);
    }

    public SimpleHtmlElementsPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idExample")));

        return this;
    }

    public ButtonSuccessPage navigateToButtonSuccessPage(String xPath){

        driver.findElement(By.xpath(xPath))
                .click();

        return new ButtonSuccessPage(driver);
    }
}
