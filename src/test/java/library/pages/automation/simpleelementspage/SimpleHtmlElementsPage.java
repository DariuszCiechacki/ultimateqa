package library.pages.automation.simpleelementspage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHtmlElementsPage extends BasePage {
    public SimpleHtmlElementsPage(WebDriver driver) {
        super(driver);
    }

    public SimpleHtmlElementsPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idExample")));

        try {
            Thread.sleep(5000);
        }catch (Exception e){}

        return this;
    }

    public ButtonSuccessPage navigateToButtonSuccessPage(String xPath){

        driver.findElement(By.xpath(xPath))
                .click();

        return new ButtonSuccessPage(driver);
    }

    public Map<String, Map<String, String>> getUniqueIdTableData(){
        Map<String, Map<String, String>> uniqueIdTableData = new HashMap<>();

        WebElement table = driver.findElement(By.id("htmlTableId"));
        List<WebElement> rows = table.findElements(By.xpath(".//td//ancestor::tr"));

        for (WebElement row : rows){
            Map<String, String> rowDetails = new HashMap<>();

            List<WebElement> columns = row.findElements(By.xpath(".//td"));

            rowDetails.put("Salary", columns.get(2).getText());
            rowDetails.put("Work", columns.get(1).getText());

            uniqueIdTableData.put(columns.get(0).getText(), rowDetails);
        }

        return uniqueIdTableData;
    }
}
