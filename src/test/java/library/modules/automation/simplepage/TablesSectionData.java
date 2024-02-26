package library.modules.automation.simplepage;

import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static drivers.Driver.driver;
import static java.lang.String.valueOf;

public class TablesSectionData {
    public Map<String, Map<String, String>> getTableData(WebElement table) {
        Map<String, Map<String, String>> tableData = new HashMap<>();

        List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        rows.forEach(row -> {
            List<WebElement> columns = row.findElements(By.xpath(".//td"));
            if (!columns.isEmpty()) {
                Map<String, String> rowDetails = new HashMap<>();
                rowDetails.put("Salary", columns.get(2).getText());
                rowDetails.put("Work", columns.get(1).getText());

                tableData.put(columns.get(0).getText(), rowDetails);
            }
        });

        return tableData;
    }
}
