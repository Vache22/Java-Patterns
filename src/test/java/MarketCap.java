import Singleton.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MarketCap {
    WebDriver driver;

    Wait<WebDriver> wait = new FluentWait<>(driver)
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setup(@Optional("chrome") String browser, @Optional("true") boolean headless) {
        WebDriverManager.getInstance(browser, headless); // ✅ Initialize WebDriver properly
        driver = WebDriverManager.getDriver(); // ✅ Retrieve the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    @Parameters({"topN"})
    public void checkStockPrices(@Optional("6") int topN) {
        driver.get("https://companiesmarketcap.com/");

        // ✅ Wait for the table to load
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));

        // ✅ Extract company names & stock prices
        List<WebElement> nameElements = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<WebElement> priceElements = driver.findElements(By.xpath("//tbody/tr/td[5]"));

        // ✅ Store in a map (Company Name -> Price)
        Map<String, Double> companyPrices = new HashMap<>();

        for (int i = 0; i < nameElements.size(); i++) {
            String name = nameElements.get(i).getText().trim();
            String priceText = (i < priceElements.size()) ? priceElements.get(i).getText().replace("$", "").replace(",", "").trim() : "0";

            try {
                double price = Double.parseDouble(priceText);
                companyPrices.put(name, price);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Skipping " + name + " (Invalid Price: " + priceText + ")");
            }
        }

        // ✅ Get top N companies by price
        List<Map.Entry<String, Double>> topCompanies = companyPrices.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()) // Sort descending
                .limit(topN)
                .toList();

        // ✅ Print results
        System.out.println("\n=====================================");
        System.out.println("Top " + topN + " Companies by Stock Price:");
        System.out.println("=====================================");
        if (topCompanies.isEmpty()) {
            System.out.println("⚠ No valid stock price data found.");
        } else {
            topCompanies.forEach(entry -> System.out.println(entry.getKey() + " - $" + entry.getValue()));
        }
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) driver.quit();
    }
}
