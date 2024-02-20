package library.modules.automation.simplepage;

import library.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static library.Driver.driver;

public class TablesSectionData {

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

    public Map<String, Map<String, String>> getNoIdTableData(){
        Map<String, Map<String, String>> uniqueIdTableData = new HashMap<>();

        WebElement table = driver.findElement(By.xpath("//table[not(@id='htmlTableId')]"));
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
