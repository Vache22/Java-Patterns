import Singleton.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class AppTest {
    private WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "headless"})
    public void setup(@Optional("chrome") String browser, @Optional("false") boolean headless) {
        WebDriverManager.getInstance(browser, headless); // ✅ Initialize WebDriver properly
        driver = WebDriverManager.getDriver(); // ✅ Retrieve the driver
    }

    @Test
    public void testSingleton(){
     driver.get("https://www.google.com");
        System.out.println(Thread.currentThread().getName() + ": " + driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.quitDriver();
    }
}
